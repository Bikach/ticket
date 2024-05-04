package com.bikach.ticket.infrastructure.controller;

import com.bikach.ticket.application.domain.model.EventPlaceRegister;
import com.bikach.ticket.application.usecase.BookPlaces;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/events")
public class EventController {

    private final BookPlaces bookPlaces;

    public EventController(BookPlaces bookPlaces) {
        this.bookPlaces = bookPlaces;
    }

    @PostMapping("/place/register")
    public ResponseEntity<Object> bookPlaces(@RequestBody EventPlaceRegister eventPlaceRegister) {
        this.bookPlaces.handler(eventPlaceRegister);
        return new ResponseEntity<>("book offices notified with success", HttpStatus.CREATED);
    }
}
