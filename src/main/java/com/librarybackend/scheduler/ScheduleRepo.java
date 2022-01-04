package com.librarybackend.scheduler;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public interface ScheduleRepo extends CrudRepository<Event,Integer> {
}
