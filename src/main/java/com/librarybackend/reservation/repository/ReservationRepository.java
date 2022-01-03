package com.librarybackend.reservation.repository;


import com.librarybackend.reservation.domain.Reservation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Long> {

    Iterable<Reservation> findAllByClientId(long clientId);

    Iterable<Reservation> findAllByDate(LocalDate date);
}
