package com.librarybackend.reservation.mapper;


import com.librarybackend.reservation.domain.Reservation;
import com.librarybackend.reservation.domain.dto.ReservationDto;
import org.springframework.stereotype.Service;

@Service
public class ReservationMapper {

    public ReservationDto mapReservationToReservationDto(Reservation reservation) {

        return ReservationDto.builder()
                .id(reservation.getId())
                .clientId((int)reservation.getClientId())
                .orderedBook(reservation.getOrderedBook())
                .date(reservation.getDate())
                .hour(reservation.getHour())
                .reservationStatus(reservation.getReservationStatus())
                .build();
    }

    public Reservation mapReservationDtoToReservation(ReservationDto reservationDto) {

        return Reservation.builder()
                .Id(reservationDto.getId())
                .clientId(reservationDto.getClientId())
                .orderedBook(reservationDto.getOrderedBook())
                .date(reservationDto.getDate())
                .hour(reservationDto.getHour())
                .reservationStatus(reservationDto.getReservationStatus())
                .build();
    }
}
