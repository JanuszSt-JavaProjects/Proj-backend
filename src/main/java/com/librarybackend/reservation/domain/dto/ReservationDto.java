package com.librarybackend.reservation.domain.dto;

import com.librarybackend.reservation.domain.OrderedBook;
import com.librarybackend.reservation.domain.Hour;
import com.librarybackend.reservation.domain.ReservationStatus;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Builder
@Data
public class ReservationDto {
    private long id;
    private int clientId;
    private OrderedBook orderedBook;
    private LocalDate date;
    private Set<Hour> hour;
    private ReservationStatus reservationStatus;
}
