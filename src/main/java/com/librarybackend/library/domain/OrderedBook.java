package com.librarybackend.library.domain;


import lombok.*;
import org.springframework.stereotype.Component;

@Component

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class OrderedBook {

    private String author;
    private String title;
    private long bookId;
}


