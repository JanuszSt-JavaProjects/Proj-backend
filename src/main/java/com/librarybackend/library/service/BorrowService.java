package com.librarybackend.library.service;

import com.librarybackend.library.domain.*;
import com.librarybackend.library.domain.dto.borrowDto.BorrowReturnDto;
import com.librarybackend.library.exception.clientException.NoSuchClientException;
import com.librarybackend.library.exception.copyException.NoAvailableCopyException;
import com.librarybackend.library.exception.copyException.NoSuchCopyException;
import com.librarybackend.library.repository.BorrowRepository;
import com.librarybackend.library.repository.CustomerRepository;
import com.librarybackend.library.repository.CopyRepository;
import com.librarybackend.library.exception.bookException.NoSuchBookException;
import com.librarybackend.library.exception.borrowException.NoSuchBorrowException;
import com.librarybackend.library.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class BorrowService {

    BorrowRepository borrowRepository;
    BookRepository bookRepository;
    CustomerRepository customerRepository;
    CopyRepository copyRepository;
    CopyService copyService;

    public BorrowService(BorrowRepository borrowRepository,
                         BookRepository bookRepository,
                         CustomerRepository customerRepository,
                         CopyRepository copyRepository,
                         CopyService copyService) {
        this.borrowRepository = borrowRepository;
        this.bookRepository = bookRepository;
        this.customerRepository = customerRepository;
        this.copyRepository = copyRepository;
        this.copyService = copyService;
    }


    public Borrow save(Borrow borrow) {

        Book book = bookRepository.findById(borrow.getBookId()).orElseThrow(NoSuchBookException::new);
        Customer customer = customerRepository.findById(borrow.getCustomer().getId()).orElseThrow(NoSuchClientException::new);

        long bookId = book.getId();
        Copy availableCopy = copyService.getFirstAvailableCopy(book.getId());
        availableCopy.setStatus(Status.IN_USE);

        Borrow newBorrow = new Borrow();

        newBorrow.setCopyId(availableCopy.getId());
        newBorrow.setCustomer(customer);
        newBorrow.setBookId(bookId);
        newBorrow.setBorrowDate(LocalDate.now());

        copyRepository.save(availableCopy);
        return borrowRepository.save(newBorrow);
    }




    public void remove(long id) {
        Borrow borrow = borrowRepository.findById(id).orElseThrow(NoSuchBorrowException::new);
        borrowRepository.delete(borrow);
    }

    public Borrow update(Borrow borrow) {
        borrowRepository.findById(borrow.getId()).orElseThrow(NoSuchBorrowException::new);
        return borrowRepository.save(borrow);
    }

    public List<Borrow> getAll() {
        return borrowRepository.findAll();
    }

    public Borrow getOne(long id) {
        return borrowRepository.findById(id).orElseThrow(NoSuchBorrowException::new);
    }


    public BorrowReturnDto returnBook(long id) {
        Borrow borrow = borrowRepository.findById(id).orElseThrow(NoSuchBorrowException::new);
        Copy copy = copyRepository.findById(borrow.getCopyId()).orElseThrow(NoSuchCopyException::new);


        if (copy.getStatus().equals(Status.AVAILABLE)) {
            throw new NoSuchBorrowException();
        }
        copy.setStatus(Status.AVAILABLE);
        borrow.setReturnDate(LocalDate.now());

        copyRepository.save(copy);
        borrowRepository.save(borrow);
        return new BorrowReturnDto(id, Status.AVAILABLE);
    }
}
