package com.librarybackend.reservation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class NoRequiredInformation extends ResponseStatusException {

    public NoRequiredInformation(){
        super(HttpStatus.BAD_REQUEST,"Please complete ALL required data!");
    }
}
