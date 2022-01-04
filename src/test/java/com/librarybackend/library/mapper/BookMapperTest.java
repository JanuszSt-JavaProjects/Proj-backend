package com.librarybackend.library.mapper;

import com.librarybackend.library.domain.Book;
import com.librarybackend.library.domain.Copy;
import com.librarybackend.library.domain.dto.bookDto.BookDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookMapperTest {
    @Autowired
    BookMapper bookMapper;

    @Test
    void mapBookDtoToBook() {

        //Given

        Copy copy = new Copy();
        Book book = new Book();
        book.setId(1);
        book.setCopies(List.of(copy));
        book.setAuthor("A");
        book.setTitle("T");
        book.setReleaseDate(2000);

        BookDto bookDto = new BookDto();
        bookDto.setAuthor("A");
        bookDto.setTitle("T");
        bookDto.setReleaseDate(2000);

        //When
        Book b = bookMapper.mapBookDtoToBook(bookDto);

        //Then
        Assertions.assertEquals(b.getAuthor(), bookDto.getAuthor());


    }

    @Test
    void mapBookToBookDto() {


        //Given

        Copy copy = new Copy();
        Book book = new Book();
        book.setId(1);
        book.setCopies(null);
        book.setAuthor("A");
        book.setTitle("T");
        book.setReleaseDate(2000);

        BookDto bookDto = new BookDto();
        bookDto.setAuthor("A");
        bookDto.setTitle("T");
        bookDto.setReleaseDate(2000);

        //When
        BookDto b = bookMapper.mapBookToBookDto(book);

        //Then
        Assertions.assertEquals(b.getAuthor(), bookDto.getAuthor());

    }
}