package com.bikach.ticket.application.domain;

import com.bikach.ticket.application.domain.model.Event;

public interface EventRepository {
    void bookPlaces(Event event);
}
