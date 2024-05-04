package com.bikach.ticket.application.usecase;

import com.bikach.ticket.application.domain.EventRepository;
import com.bikach.ticket.application.domain.model.EventPlaceRegister;


public class BookPlaces {

    private final EventRepository repository;

    public BookPlaces(EventRepository repository) {
        this.repository = repository;
    }

    public void handler(EventPlaceRegister eventPlaceRegister) {
        this.repository.bookPlaces(eventPlaceRegister);
    }
}
