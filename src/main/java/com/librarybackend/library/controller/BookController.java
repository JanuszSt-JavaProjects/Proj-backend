package com.librarybackend.library.controller;

import com.librarybackend.library.domain.Book;
import com.librarybackend.library.domain.dto.bookDto.BookDto;
import com.librarybackend.library.mapper.BookMapper;
import com.librarybackend.library.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("library/books")
public class BookController {

    BookMapper bookMapper;
    BookService bookService;


    public BookController(BookMapper bookMapper,
                          BookService bookService) {
        this.bookMapper = bookMapper;
        this.bookService = bookService;
    }

    @PostMapping(consumes = "application/json")
    public BookDto create(@RequestBody BookDto bookCreateDto) {
        bookService.checkIfComplete(bookCreateDto);
        Book book = bookService.extractBook(bookCreateDto);

        return bookMapper.mapBookToBookDto(bookService.save(book));

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        bookService.delete(id);
    }

    @PutMapping
    public BookDto update(@RequestBody BookDto bookDto) {
        System.out.println(bookDto.getId());
        Book book = bookMapper.mapBookDtoToBook(bookDto);
        System.out.println(book.getId());
        book = bookService.update(book);
        return bookMapper.mapBookToBookDto(book);
    }

    @GetMapping("/{id}")
    public BookDto getOne(@PathVariable long id) {
        Book book = bookService.getOne(id);
        return bookMapper.mapBookToBookDto(book);
    }

    @GetMapping
    public List<BookDto> getAll() {

        List<BookDto> bookDtos = new LinkedList<>();

        bookService.getAll().forEach(book -> bookDtos.add(bookMapper.mapBookToBookDto(book)));
        return bookDtos;
    }
}
