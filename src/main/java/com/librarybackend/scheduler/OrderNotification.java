package com.librarybackend.scheduler;

import com.librarybackend.reservation.service.ReservationService;
import lombok.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Value
@Component
public class OrderNotification {

    ReservationService reservationService;
    ScheduleMapper scheduleMapper;
    EventRepository eventRepository;


    @GetMapping("qqq")


//    @Scheduled(cron = "0 0 10 * * *")
    public void saveEvents() {
        List<Event> eventsToSave = new ArrayList<>();


      eventsToSave =  scheduleMapper.mapToEvents(
                reservationService.getAllFromDay(LocalDate.now()));

      eventsToSave =  scheduleMapper.mapToEvents(
                reservationService.getAllFromDay(LocalDate.now().minusDays(1)));
      eventRepository.saveAll(eventsToSave);

            }
}