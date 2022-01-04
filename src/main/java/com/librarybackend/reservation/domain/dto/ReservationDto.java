package com.librarybackend.reservation.domain.dto;

import com.librarybackend.reservation.domain.OrderedBook;
import com.librarybackend.reservation.domain.ReservationStatus;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Builder
@Data
public class ReservationDto {
    private long id;
    private int clientId;
    private OrderedBook orderedBook;
    private LocalDate date;
    private ReservationStatus reservationStatus;
}
