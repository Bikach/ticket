package com.bikach.ticket.application.domain.model;

import java.util.List;
import java.util.stream.Collectors;

public record EventPlaceRegister(String name, List<Place> bookedPlaces) {
    public String joinBookedPlaces() {
        return this.bookedPlaces.stream()
                .map(place -> STR."[\{place.rank()}, \{place.seatNumber()}]")
                .collect(Collectors.joining(", "));
    }
}
