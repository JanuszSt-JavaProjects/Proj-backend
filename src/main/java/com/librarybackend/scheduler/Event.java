package com.librarybackend.scheduler;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;


@Data
@ToString
@NoArgsConstructor
@Entity
@Component
public class Event {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    private LocalDate orderDate;
    private long bookId;
    private String author;
    private String BookTitle;

    public Event(LocalDate orderDate, int bookId, String author, String bookTitle) {
        this.orderDate = orderDate;
        this.bookId = bookId;
        this.author = author;
        BookTitle = bookTitle;
    }
}

