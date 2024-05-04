package com.bikach.ticket.application.domain;

import com.bikach.ticket.application.domain.model.EventPlaceRegister;

public interface EventRepository {
    void bookPlaces(EventPlaceRegister eventPlaceRegister);
}
