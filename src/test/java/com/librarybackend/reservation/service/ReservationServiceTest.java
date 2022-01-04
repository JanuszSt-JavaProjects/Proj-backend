package com.librarybackend.reservation.service;

import com.librarybackend.reservation.domain.OrderedBook;
import com.librarybackend.reservation.domain.Reservation;
import com.librarybackend.reservation.domain.ReservationStatus;
import com.librarybackend.reservation.repository.ReservationRepository;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class ReservationServiceTest {

    @Autowired
    ReservationService reservationService;
    @Autowired
    ReservationRepository reservationRepository;

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
        reservation1 = new Reservation(0, LocalDate.now(), 1L, book1, LocalDate.now(), ReservationStatus.RESERVED);
        reservation2 = new Reservation(2L, LocalDate.now(), 2L, book2, LocalDate.now().minusDays(1), ReservationStatus.RESERVED);

    }

    @Test
    void save() {

        //Given
        List<Reservation> input = new ArrayList<>();
        List<Reservation> output = new ArrayList<>();

        reservationRepository.findAll().forEach(input::add);
        int first = input.size();


        //When
        reservationService.save(reservation1);
        reservationRepository.findAll().forEach(output::add);
        int last = output.size();


        //Then
        Assertions.assertEquals(last, first + 1);
    }

    @Test
    void remove() {


        //Given
        List<Reservation> input = new ArrayList<>();
        List<Reservation> output = new ArrayList<>();

        reservationService.save(reservation1);
        reservationService.save(reservation2);

        reservationRepository.findAll().forEach(input::add);
        int inputCount = input.size();
        long id = input.get(0).getId();

        //When

        reservationService.remove(id);

        //Then
        reservationRepository.findAll().forEach(output::add);
        int outputCount = output.size();

        Assertions.assertEquals(outputCount,inputCount-1);

    }

    @Test
    void update() {


    }

    @Test
    void getOne() {
    }

    @Test
    void getAll() {
    }

    @Test
    void getAllForClient() {
    }

    @Test
    void getAllForDay() {
    }

    @Test
    void getAllFromDay() {
    }
}