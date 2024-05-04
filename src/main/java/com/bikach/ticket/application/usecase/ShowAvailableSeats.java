package com.bikach.ticket.application.usecase;

import com.bikach.ticket.application.domain.EventRepository;
import com.bikach.ticket.application.domain.model.Seat;

import java.util.List;

public class ShowAvailableSeats {

    private final EventRepository eventRepository;

    public ShowAvailableSeats(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<Seat> availableSeats(String eventId) {
        var event = this.eventRepository.findAvailableSeatsByEventId(eventId);
        return event.availableSeats();
    }
}
