package com.librarybackend.reservation.mapper;

import com.librarybackend.reservation.domain.OrderedBook;
import com.librarybackend.reservation.domain.Reservation;
import com.librarybackend.reservation.domain.ReservationStatus;
import com.librarybackend.reservation.domain.dto.ReservationDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
class ReservationMapperTest {

    @Autowired
    ReservationMapper reservationMapper;

    OrderedBook book1;
    OrderedBook book2;

    Reservation reservation1;
    Reservation reservation2;

    @BeforeEach
    public void before() {

        book1 = OrderedBook.builder()
                .bookId(100L)
                .author("Author1")
                .title("Title1")
                .build();
        book2 = OrderedBook.builder()
                .bookId(200L)
                .author("Author2")
                .title("Title2")
                .build();
        reservation1 = new Reservation(0, LocalDate.now(), 1L, book1, LocalDate.now().minusDays(15), ReservationStatus.RESERVED);
        reservation2 = new Reservation(2L, LocalDate.now(), 2L, book2, LocalDate.now().minusDays(1), ReservationStatus.RESERVED);

    }

    @Test
    void mapReservationToReservationDto() {

        //Given
        ReservationDto base = ReservationDto.builder()
                .clientId(1)
                .orderedBook(book1)
                .date(LocalDate.now().minusDays(15))
                .reservationStatus(ReservationStatus.RESERVED)
                .build();
        //When
        ReservationDto tested = reservationMapper.mapReservationToReservationDto(reservation1);

        //Then
        Assertions.assertEquals(tested, base);

    }

    @Test
    void mapReservationDtoToReservation() {

        //Given
        ReservationDto base = ReservationDto.builder()
                .clientId(1)
                .orderedBook(book1)
                .date(LocalDate.now().minusDays(15))
                .reservationStatus(ReservationStatus.RESERVED)
                .build();
        reservation1 = new Reservation(0,null, 1L, book1, LocalDate.now().minusDays(15), ReservationStatus.RESERVED);

        //When
        Reservation tested = reservationMapper.mapReservationDtoToReservation(base);

        //Then
        Assertions.assertEquals(tested, reservation1);

    }
}