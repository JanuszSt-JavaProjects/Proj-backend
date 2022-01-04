package com.librarybackend.reservation.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data

@Builder
public class Reservation {
    @Id
    @GeneratedValue
    private long Id;

    private long clientId;

    @OneToOne(cascade = CascadeType.ALL,fetch =FetchType.EAGER)
    private OrderedBook orderedBook;

    private LocalDate date;

    @Enumerated(EnumType.STRING)
    private ReservationStatus reservationStatus;
}
