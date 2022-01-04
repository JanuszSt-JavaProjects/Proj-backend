package com.librarybackend.scheduler;

import com.librarybackend.reservation.service.ReservationService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@Service
@Component
public class OrderNotification {

    private ReservationService reservationService;
    private ScheduleMapper scheduleMapper;
    private EventRepository eventRepository;

    private List<Event> eventsToSave;


    @Scheduled(cron = "0 0 10 * * *")
    public void saveEvents() {
        Event defaultEv = new Event(LocalDate.now().minusDays(1), 0, "No Author", "No Title");


        eventsToSave = scheduleMapper.mapToEvents(
                reservationService.getAllFromDay(LocalDate.now().minusDays(1)));

        if (!eventsToSave.isEmpty()) {
            eventRepository.saveAll(eventsToSave);
        } else {

            eventRepository.save(defaultEv);
        }
    }
}