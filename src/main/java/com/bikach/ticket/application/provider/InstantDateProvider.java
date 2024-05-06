package com.bikach.ticket.application.provider;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class InstantDateProvider implements DateProvider {
    @Override
    public LocalDateTime dateNow() {
        return LocalDateTime.now();
    }
}
