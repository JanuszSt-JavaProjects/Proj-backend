package com.librarybackend.library.service;

import com.librarybackend.library.domain.Book;
import com.librarybackend.library.domain.Copy;
import com.librarybackend.library.domain.Status;
import com.librarybackend.library.domain.dto.bookDto.BookDto;
import com.librarybackend.library.exception.bookException.BookAlreadyExistsException;
import com.librarybackend.library.exception.bookException.NoNeededFieldException;
import com.librarybackend.library.exception.bookException.NoSuchBookException;
import com.librarybackend.library.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class BookService {
    BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book save(Book book) {
        if (checkIfExists(book)) {
            throw new BookAlreadyExistsException();
        }

        return bookRepository.save(book);
    }

    public void delete(long Id) {
        Book book = bookRepository.findById(Id).orElseThrow(NoSuchBookException::new);
        bookRepository.delete(book);
    }

    public Book update(Book book) {
        Book updatedBook = bookRepository.findById(book.getId()).orElseThrow(NoSuchBookException::new);
        updatedBook.setId(book.getId());
        updatedBook.setTitle(book.getTitle());
        updatedBook.setAuthor(book.getAuthor());
        updatedBook.setReleaseDate(book.getReleaseDate());
        bookRepository.save(updatedBook);

        return updatedBook;
    }

    public Book getOne(long Id) {
        return bookRepository.findById(Id).orElseThrow(NoSuchBookException::new);
    }

    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    public Book extractBook(BookDto bookCreateDto) {

        Book book = new Book();
        book.setTitle(bookCreateDto.getTitle());
        book.setAuthor(bookCreateDto.getAuthor());
        book.setReleaseDate(bookCreateDto.getReleaseDate());

        return book;
    }


    private boolean checkIfExists(Book book) {
        return bookRepository.existsByAuthorAndTitle(book.getAuthor(), book.getTitle());
    }


    public void checkIfComplete(BookDto bookCreateDto) {

        System.out.println(bookCreateDto);

        boolean check = Stream.of(
                        bookCreateDto.getTitle(),
                        bookCreateDto.getAuthor(),
                        bookCreateDto.getReleaseDate())
                .allMatch(Objects::nonNull);

        if (!check) {
            throw new NoNeededFieldException();
        }
    }


    public List<Book> getByAuthor(String value) {

        List<Book> books = bookRepository.findByAuthor(value);
        List<Copy> copies = books.stream().map(Book::getCopies)
                .flatMap(Collection::stream)
                .filter(x -> x.getStatus().equals(Status.AVAILABLE))
                .collect(Collectors.toList());

 List<Book> result=new ArrayList<>();
        copies.forEach(x -> result.add(bookRepository.findById(x.getBook().getId()).get()));
        return result;
    }
}

