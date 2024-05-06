package com.bikach.ticket.infrastructure.controller;

import com.bikach.ticket.application.domain.model.Event;
import com.bikach.ticket.application.usecase.EventPlaceRegister;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/events")
public class EventController {

    private final EventPlaceRegister eventPlaceRegister;

    public EventController(EventPlaceRegister eventPlaceRegister) {
        this.eventPlaceRegister = eventPlaceRegister;
    }

    @PostMapping("/place/register")
    @SendTo("/topic/bookedPlaces")
    public Event bookPlaces(@RequestBody Event event) {
        this.eventPlaceRegister.handler(event);
        return event;
    }
}
