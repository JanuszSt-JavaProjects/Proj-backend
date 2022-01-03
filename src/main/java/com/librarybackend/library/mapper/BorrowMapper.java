package com.librarybackend.library.mapper;



import com.librarybackend.library.domain.Borrow;
import com.librarybackend.library.domain.Customer;
import com.librarybackend.library.domain.dto.borrowDto.BorrowDto;
import com.librarybackend.library.exception.clientException.NoSuchClientException;
import com.librarybackend.library.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class BorrowMapper {

    CustomerRepository customerRepository;

    public BorrowMapper(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Borrow mapBorrowDtoToBorrow(BorrowDto borrowDto) {

        Borrow borrow = new Borrow();

        borrow.setId(borrowDto.getId());
        borrow.setBookId(borrowDto.getBookId());
        borrow.setCopyId(borrow.getCopyId());
        borrow.setBorrowDate(borrowDto.getBorrowDate());
        try {
            borrow.setReturnDate(borrowDto.getReturnDate());
        }catch (Exception e){
            borrow.setReturnDate(null);
        }



        borrow.setCustomer(customerRepository.findById(borrowDto.getClientId()).orElseThrow(NoSuchClientException::new));
        return borrow;
    }

    public BorrowDto mapBorrowToBorrowDto(Borrow borrow) {

        BorrowDto borrowDto = new BorrowDto();

        borrowDto.setId(borrow.getId());
        borrowDto.setClientId(borrow.getCustomer().getId());
        borrowDto.setBookId(borrow.getBookId());
        borrowDto.setCopyId(borrow.getCopyId());
        borrowDto.setBorrowDate(borrow.getBorrowDate());
        borrowDto.setReturnDate(borrow.getReturnDate());
        return borrowDto;
    }
}
