package com.librarybackend.scheduler;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;


@NoArgsConstructor
@Entity
@Component
public class Event {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private LocalDate eventDate;
    private long bookId;
    private String author;
    private String BookTitle;

    public Event(LocalDate eventDate, int bookId, String author, String bookTitle) {
        this.eventDate = eventDate;
        this.bookId = bookId;
        this.author = author;
        BookTitle = bookTitle;
    }
}

