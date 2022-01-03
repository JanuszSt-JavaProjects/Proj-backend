package com.librarybackend.library.domain.dto.customerDto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CustomerDto {

    private long id;
    private String firstname;
    private String lastname;
    private LocalDate createAccountDate;
}
