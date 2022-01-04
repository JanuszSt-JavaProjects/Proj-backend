package com.librarybackend.library.exception.copyException;

import com.librarybackend.library.domain.Book;
import com.librarybackend.library.domain.Copy;
import com.librarybackend.library.exception.bookException.BookAlreadyExistsException;
import com.librarybackend.library.service.BookService;
import com.librarybackend.library.service.CopyService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class NoSuchCopyExceptionTest {
    @Autowired
    CopyService copyService;

    @Autowired
    BookService bookService;

    @Test
    public void noSuchCopy() {
        //Given
        Copy copy = new Copy();
        copy.setId(1000000);


        NoSuchCopyException exception = new NoSuchCopyException();

        //When
        Exception e = Assertions.assertThrows(NoSuchCopyException.class,
                () ->
                {
                    copyService.get(copy.getId());
                });

        //Then
        Assertions.assertEquals(e.getClass(), exception.getClass());

    }

}