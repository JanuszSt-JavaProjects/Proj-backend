package com.librarybackend.scheduler;

import com.librarybackend.reservation.domain.Reservation;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Data
@Service
public class ScheduleMapper {

    public List<Event> mapToEvents(List<Reservation> reservations) {

        List<Event> events = new ArrayList<>();

        for (Reservation re : reservations) {

            Event event = new Event();
            event.setOrderDate(re.getCreationDate());
            event.setBookId(re.getOrderedBook().getBookId());
            event.setAuthor(re.getOrderedBook().getAuthor());
            event.setBookTitle(re.getOrderedBook().getTitle());
            events.add(event);
        }

        return events;
    }
}
