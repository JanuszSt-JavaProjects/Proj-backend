package com.librarybackend.library.domain.dto.bookDto;

import com.librarybackend.library.domain.Status;
import lombok.Getter;

@Getter
public class BookCreateDto {

    private String title;
    private String author;
    private int releaseDate;

    private String signature;
    private Status status = Status.AVAILABLE;
}
