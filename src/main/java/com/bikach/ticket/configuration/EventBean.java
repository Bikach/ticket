package com.bikach.ticket.configuration;

import com.bikach.ticket.application.domain.EventRepository;
import com.bikach.ticket.application.usecase.EventPlaceRegister;
import jakarta.transaction.Transactional;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EventBean {

    @Bean
    @Transactional
    public EventPlaceRegister bookPlaces(EventRepository repository) {
        return new EventPlaceRegister(repository);
    }

}
