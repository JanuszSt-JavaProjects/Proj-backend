package com.librarybackend.scheduler;


import com.librarybackend.reservation.domain.OrderedBook;
import com.librarybackend.reservation.domain.Reservation;
import com.librarybackend.reservation.domain.ReservationStatus;
import com.librarybackend.reservation.service.ReservationService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class OrderNotificationTest {


    @Test
    void getReservationService() {
        //Given

        ReservationService reservationServiceMock = Mockito.mock(ReservationService.class);
        EventRepository eventRepositoryMck = Mockito.mock(EventRepository.class);
        ScheduleMapper scheduleMapper = new ScheduleMapper();

        List<Event> events = new ArrayList<>();

        OrderNotification tested = new OrderNotification(
                reservationServiceMock,
                scheduleMapper,
                eventRepositoryMck,
                events);

        OrderedBook orderedBook = new OrderedBook();
        orderedBook.setTitle("aaa");
        Reservation reservation = new Reservation(1L, LocalDate.now(), 1L, orderedBook, LocalDate.now().minusDays(1), ReservationStatus.RESERVED);
        when(reservationServiceMock.getAllFromDay(any())).thenReturn(List.of(reservation));

        //When
        tested.saveEvents();
        //Then
        List<Event> eventsToSave = tested.getEventsToSave();
        Assertions.assertEquals(1, eventsToSave.size());
        Assertions.assertEquals("aaa", eventsToSave.get(0).getBookTitle());
        Assertions.assertTrue(tested.toString().contains("aaa"));

    }
}
