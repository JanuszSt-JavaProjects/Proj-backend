package com.librarybackend.readingRoom.reservation.domain.dto;

import com.librarybackend.readingRoom.reservation.domain.OrderedBook;
import com.librarybackend.readingRoom.reservation.domain.Hour;
import com.librarybackend.readingRoom.reservation.domain.ReservationStatus;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Builder
@Data
public class ReservationDto {
    private long id;
    private long clientId;
    private OrderedBook orderedBook;
    private LocalDate date;
    private Set<Hour> hour;
    private ReservationStatus reservationStatus;
}
