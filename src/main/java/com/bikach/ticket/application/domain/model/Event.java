package com.bikach.ticket.application.domain.model;

import java.util.List;

import static com.bikach.ticket.application.domain.model.Status.SOLD_OUT;
import static com.bikach.ticket.application.domain.model.Status.TICKET_AVAILABLE;

public record Event(List<Seat> availableSeats) {

    public Status status() {
        return availableSeats
                .stream()
                .findAny()
                .map(_ -> TICKET_AVAILABLE)
                .orElse(SOLD_OUT);
    }

}
