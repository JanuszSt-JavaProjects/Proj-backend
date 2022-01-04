package com.librarybackend.scheduler;

import com.librarybackend.reservation.domain.Reservation;
import com.librarybackend.reservation.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
@RestController                     /////////////////////////
@RequestMapping("/qqq")
public class OrderNotification {

    @Autowired
    ReservationRepository reservationRepository;
    @Autowired
    ScheduleMapper scheduleMapper;

    @GetMapping                          ///////////////////////

//    @Scheduled(cron = "0 0 10 * * *")
    public void saveEvents() {
        List<Event> eventsToSave = new ArrayList<>();

        Iterable<Reservation> reservations = reservationRepository.findAll();



        System.out.println(reservations);

    }
}