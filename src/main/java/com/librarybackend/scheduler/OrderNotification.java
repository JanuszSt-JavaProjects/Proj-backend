package com.librarybackend.scheduler;

import com.librarybackend.reservation.service.ReservationService;
import lombok.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Value
@Component
public class OrderNotification {

    ReservationService reservationService;
    ScheduleMapper scheduleMapper;
    EventRepository eventRepository;


    @Scheduled(cron = "0 0 10 * * *")
    public void saveEvents() {
        Event defaultEv = new Event(LocalDate.now().minusDays(1), 0, " ----------------- ", " -------------");

        List<Event> eventsToSave;

        eventsToSave = scheduleMapper.mapToEvents(
                reservationService.getAllFromDay(LocalDate.now().minusDays(1)));

        if (!eventsToSave.isEmpty()) {
            eventRepository.saveAll(eventsToSave);
        } else {

            eventRepository.save(defaultEv);
        }
    }
}