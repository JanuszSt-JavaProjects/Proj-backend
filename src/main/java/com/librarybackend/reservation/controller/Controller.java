package com.librarybackend.reservation.controller;


import com.librarybackend.reservation.domain.Reservation;
import com.librarybackend.reservation.domain.dto.ReservationDto;
import com.librarybackend.reservation.mapper.ReservationMapper;
import com.librarybackend.reservation.service.ReservationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reservations")
public class Controller {


    ReservationService reservationService;
    ReservationMapper reservationMapper;

    public Controller(ReservationService reservationService,
                      ReservationMapper reservationMapper) {
        this.reservationService = reservationService;
        this.reservationMapper = reservationMapper;
    }

    @PostMapping
    public ReservationDto create(@RequestBody ReservationDto reservationDto) {

        Reservation reservation =reservationMapper.mapReservationDtoToReservation(reservationDto);
        Reservation save = reservationService.save(reservation);

        return reservationMapper.mapReservationToReservationDto(save);
    }

}
