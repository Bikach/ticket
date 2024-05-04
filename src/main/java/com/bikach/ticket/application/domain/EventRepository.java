package com.bikach.ticket.application.domain;

import com.bikach.ticket.application.domain.model.Event;

public interface EventRepository {
    Event findAvailableSeatsByEventId(String eventId);
}
