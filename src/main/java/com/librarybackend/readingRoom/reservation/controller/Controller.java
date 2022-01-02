package com.librarybackend.readingRoom.reservation.controller;

import com.librarybackend.readingRoom.reservation.domain.Hour;
import com.librarybackend.readingRoom.reservation.domain.OrderedBook;
import com.librarybackend.readingRoom.reservation.domain.Reservation;
import com.librarybackend.readingRoom.reservation.domain.ReservationStatus;
import com.librarybackend.readingRoom.reservation.domain.dto.ReservationDto;
import com.librarybackend.readingRoom.reservation.service.ReservationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Set;

@RestController
@RequestMapping("/reading-room/reservations")
public class Controller {


    ReservationService reservationService;

    public Controller(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping
    public ReservationDto create() {

        return ReservationDto.builder()
                .clientId(1)
                .date(LocalDate.now())
                .hour(Set.of(Hour.HOUR_10_11, Hour.HOUR_11_12, Hour.HOUR_13_14))
                .orderedBook(OrderedBook.builder()
                        .author("Jonathan Smith")
                        .title("Any Title")
                        .build())
                .reservationStatus(ReservationStatus.RESERVED)
                .build();

    }

}
