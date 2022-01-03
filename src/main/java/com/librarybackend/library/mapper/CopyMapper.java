package com.librarybackend.library.mapper;


import com.librarybackend.library.domain.Book;
import com.librarybackend.library.domain.Copy;
import com.librarybackend.library.domain.dto.copyDto.CopyDto;
import com.librarybackend.library.repository.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class CopyMapper {

    BookRepository bookRepository;

    public CopyMapper(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Copy mapCopyDtoToCopy(CopyDto copyDto) {
        Copy copy = new Copy();

        Book book=bookRepository.findById(copyDto.getBookId()).get();
        copy.setId(copyDto.getId());
        copy.setSignature(copyDto.getSignature());
        copy.setStatus(copyDto.getStatus());
        copy.setBook(book);
        return copy;
    }

    public CopyDto mapCopyToCopyDto(Copy copy) {

        CopyDto copyDto = new CopyDto();
         copyDto.setBookId(copy.getBook().getId());
        copyDto.setId(copy.getId());
        copyDto.setStatus(copy.getStatus());
        copyDto.setSignature(copy.getSignature());

        return copyDto;
    }
}
