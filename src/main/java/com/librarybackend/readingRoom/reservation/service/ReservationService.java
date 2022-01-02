package com.librarybackend.readingRoom.reservation.service;


import com.librarybackend.library.service.CustomerService;
import com.librarybackend.readingRoom.reservation.domain.Reservation;
import com.librarybackend.readingRoom.reservation.exception.NoRequiredInformation;
import com.librarybackend.readingRoom.reservation.exception.NoSuchReservationException;
import com.librarybackend.readingRoom.reservation.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class ReservationService {
    ReservationRepository reservationRepo;
    CustomerService customerService;

    public ReservationService(ReservationRepository reservationRepo,
                              CustomerService customerService) {
        this.reservationRepo = reservationRepo;
        this.customerService = customerService;
    }

    public Reservation save(Reservation reservation) {
        Optional.ofNullable(reservation).orElseThrow(NoRequiredInformation::new);
        return reservationRepo.save(reservation);
    }

    public void remove(long id) {
        reservationRepo.findById(id).orElseThrow(NoSuchReservationException::new);
        reservationRepo.deleteById(id);
    }

    public Reservation update(Reservation reservation) {
        reservationRepo.findById(reservation.getId()).orElseThrow(NoSuchReservationException::new);
        return reservationRepo.save(reservation);
    }

    public Reservation getOne(long id) {
        return reservationRepo.findById(id).orElseThrow(NoSuchReservationException::new);
    }

    public Iterable<Reservation> getAll() {
        return reservationRepo.findAll();
    }

    public Iterable<Reservation> getAllForClient(long clientId) {
        customerService.getOne(clientId);
        return reservationRepo.findAllByClientId(clientId);
    }

    public Iterable<Reservation> getAllForDay(LocalDate date) {
        return reservationRepo.findAllByDate(date);
    }
}
