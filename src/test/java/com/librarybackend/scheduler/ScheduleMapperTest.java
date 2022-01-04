package com.librarybackend.scheduler;

import com.librarybackend.reservation.domain.OrderedBook;
import com.librarybackend.reservation.domain.Reservation;
import com.librarybackend.reservation.domain.ReservationStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
class ScheduleMapperTest {

@Test
    public void mapToEvents() {


        //Given
        ScheduleMapper scheduleMapper = new ScheduleMapper();

        OrderedBook book = new OrderedBook();
        book.setId(1L);
        book.setBookId(55);
        book.setAuthor("Auth");
        book.setTitle("Title");


        Reservation reservation = new Reservation(1L, LocalDate.now(), 1L, book, LocalDate.now(), ReservationStatus.RESERVED);
        Event event =new Event(LocalDate.now(),55,"Auth","Title");
        //When
        List<Event> events = scheduleMapper.mapToEvents(List.of(reservation));

    System.out.println(events);
        //Then
        Assertions.assertEquals(1,events.size());
        Assertions.assertEquals("Title",events.get(0).getBookTitle());


}
}
