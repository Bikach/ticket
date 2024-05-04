package com.bikach.ticket.configuration;

import com.bikach.ticket.application.domain.EventRepository;
import com.bikach.ticket.application.usecase.BookPlaces;
import jakarta.transaction.Transactional;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EventBean {

    @Bean
    @Transactional
    public BookPlaces bookPlaces(EventRepository repository) {
        return new BookPlaces(repository);
    }

}
