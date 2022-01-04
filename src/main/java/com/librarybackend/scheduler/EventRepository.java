package com.librarybackend.scheduler;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface EventRepository extends CrudRepository<Event, Long> {

}
