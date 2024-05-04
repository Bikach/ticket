package com.bikach.ticket.application.provider;

import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class InstantDateProvider implements DateProvider {
    @Override
    public LocalDate dateNow() {
        return LocalDate.now();
    }
}
