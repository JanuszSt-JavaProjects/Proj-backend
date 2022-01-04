package com.librarybackend.scheduler;

import com.librarybackend.reservation.domain.Reservation;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ScheduleMapper {

    public List<Event> mapToEvents(List <Reservation> reservations){

        List <Event> events = new ArrayList<>();

        reservations.stream()
                .forEach(x->events.add(new Event(x.getDate(),
                        (int) x.getOrderedBook().getBookId(),
                        x.getOrderedBook().getAuthor(),
                        x.getOrderedBook().getTitle()))
                );

        return events;
    }
}
