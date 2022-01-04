package com.librarybackend.library.mapper;

import com.librarybackend.library.domain.Borrow;
import com.librarybackend.library.domain.Customer;
import com.librarybackend.library.domain.dto.borrowDto.BorrowDto;
import com.librarybackend.library.exception.borrowException.NoSuchBorrowException;
import com.librarybackend.library.exception.clientException.NoSuchClientException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
class BorrowMapperTest {
    @Autowired
    BorrowMapper borrowMapper;

    @Test
    void mapBorrowDtoToBorrow() {

        Customer customer = new Customer();
        customer.setId(11);
        customer.setFirstname("John");
        customer.setLastname("Smith");
        customer.setCreateAccountDate(LocalDate.now());

        Borrow borrow = new Borrow();
        borrow.setBorrowDate(LocalDate.now());
        borrow.setReturnDate(LocalDate.now());
        borrow.setId(1);
        borrow.setBookId(1);
        borrow.setCustomer(customer);


        BorrowDto borrowDto = new BorrowDto();
        borrowDto.setBorrowDate(LocalDate.now());
        borrowDto.setBookId(1);
        borrowDto.setReturnDate(LocalDate.now());
        borrowDto.setClientId(11);
        borrowDto.setCopyId(0);
        borrowDto.setId(1);

        BorrowDto checked = borrowMapper.mapBorrowToBorrowDto(borrow);

        Assertions.assertEquals(checked, borrowDto);

    }

    @Test
    void mapBorrowToBorrowDto() {


        Customer customer = new Customer();
        customer.setId(1);
        customer.setFirstname("John");
        customer.setLastname("Smith");
        customer.setCreateAccountDate(LocalDate.now());

        Borrow borrow = new Borrow();
        borrow.setBorrowDate(LocalDate.now());
        borrow.setReturnDate(LocalDate.now());
        borrow.setId(1);
        borrow.setBookId(1);
        borrow.setCustomer(customer);


        BorrowDto borrowDto = new BorrowDto();
        borrowDto.setBorrowDate(LocalDate.now());
        borrowDto.setBookId(1);
        borrowDto.setReturnDate(LocalDate.now());
        borrowDto.setClientId(1000);
        borrowDto.setCopyId(0);
        borrowDto.setId(1);

        NoSuchClientException exception = new NoSuchClientException();


        //When
        Exception exc = Assertions.assertThrows(NoSuchClientException.class, () -> {
            borrowMapper.mapBorrowDtoToBorrow(borrowDto);
        });

        Assertions.assertEquals(exc.getClass(), exception.getClass());

    }
}