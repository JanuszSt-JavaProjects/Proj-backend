package com.librarybackend.library.mapper;


import com.librarybackend.library.domain.Customer;
import com.librarybackend.library.domain.dto.customerDto.CustomerDto;
import org.springframework.stereotype.Service;

@Service
public class ClientMapper {

    public Customer mapClientDtoToClient(CustomerDto customerDto) {

        Customer customer = new Customer();

        customer.setId(customerDto.getId());
        customer.setFirstname(customerDto.getFirstname());
        customer.setLastname(customerDto.getLastname());
        customer.setCreateAccountDate(customerDto.getCreateAccountDate());
        return customer;
    }


    public CustomerDto mapClientToClientDto(Customer customer) {

        CustomerDto customerDto = new CustomerDto();

        customerDto.setId(customer.getId());
        customerDto.setFirstname(customer.getFirstname());
        customerDto.setLastname(customer.getLastname());
        customerDto.setCreateAccountDate(customer.getCreateAccountDate());

        return customerDto;
    }
}
