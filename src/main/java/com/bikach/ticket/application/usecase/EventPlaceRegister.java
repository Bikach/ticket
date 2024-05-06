package com.bikach.ticket.application.usecase;

import com.bikach.ticket.application.domain.EventRepository;
import com.bikach.ticket.application.domain.model.Event;


public class EventPlaceRegister {

    private final EventRepository repository;

    public EventPlaceRegister(EventRepository repository) {
        this.repository = repository;
    }

    public void handler(Event event) {
        this.repository.bookPlaces(event);
    }
}
