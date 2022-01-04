package com.librarybackend.library.service;

import com.librarybackend.library.exception.bookException.NoSuchBookException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

@SpringBootTest
class BookServiceTest {

    @Autowired
    BookService bookService;

    @Test
    void getOne() {

        // Given
        NoSuchBookException message = new NoSuchBookException();
        long id = 10000;

        //When
        Exception exc= Assertions.assertThrows(NoSuchBookException.class, () -> {
            bookService.getOne(id);
        });

        Assertions.assertEquals(exc.getMessage(),message.getMessage());
        Assertions.assertEquals(exc.getClass(),message.getClass());
    }
}