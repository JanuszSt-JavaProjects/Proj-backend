package com.librarybackend.library.mapper;

import com.librarybackend.library.domain.Customer;
import com.librarybackend.library.domain.dto.customerDto.CustomerDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
class ClientMapperTest {
    @Autowired
    ClientMapper clientMapper;

    @Test
    void mapClientDtoToClient() {

        //Given
        Customer customer = new Customer();
        customer.setId(1);
        customer.setLastname("L");
        customer.setFirstname("F");
        customer.setBorrows(null);
        customer.setCreateAccountDate(LocalDate.now());

        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(1);
        customerDto.setFirstname("F");
        customerDto.setLastname("L");
        customerDto.setCreateAccountDate(LocalDate.now());

        //When

        Customer c = clientMapper.mapClientDtoToClient(customerDto);

        //Then

        Assertions.assertEquals(c.getFirstname(), customerDto.getFirstname());
    }

    @Test
    void mapClientToClientDto() {


        //Given
        Customer customer = new Customer();
        customer.setId(1);
        customer.setLastname("L");
        customer.setFirstname("F");
        customer.setBorrows(null);
        customer.setCreateAccountDate(LocalDate.now());

        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(1);
        customerDto.setFirstname("F");
        customerDto.setLastname("L");
        customerDto.setCreateAccountDate(LocalDate.now());

        //When

        CustomerDto c = clientMapper.mapClientToClientDto(customer);

        //Then

        Assertions.assertEquals(c.getFirstname(), customer.getFirstname());
    }
}
