package com.bikach.ticket.application.exceptions;

import com.bikach.ticket.application.domain.model.EventPlaceRegister;

public class BookPlacesException extends RuntimeException {
    public BookPlacesException(EventPlaceRegister eventPlaceRegister, String cause) {
        super(String.format("An error on the following event: %s occurred dut to: %s", eventPlaceRegister.name(), cause));
    }
}
