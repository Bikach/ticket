package com.bikach.ticket.infrastructure.repositories;

import com.bikach.ticket.application.domain.EventRepository;
import com.bikach.ticket.application.domain.model.EventPlaceRegister;
import com.bikach.ticket.application.provider.DateProvider;
import com.bikach.ticket.infrastructure.repositories.entity.EventHistoryEntity;
import org.springframework.stereotype.Repository;

@Repository
public class PostgresJpaEventRepository implements EventRepository {
    private final JpaEventRepository eventRepository;
    private final DateProvider dateProvider;

    public PostgresJpaEventRepository(JpaEventRepository eventRepository, DateProvider dateProvider) {
        this.eventRepository = eventRepository;
        this.dateProvider = dateProvider;
    }

    @Override
    public void bookPlaces(EventPlaceRegister eventPlaceRegister) {
        var eventEntity = mapToEventEntity(eventPlaceRegister);
        eventRepository.save(eventEntity);
    }

    private EventHistoryEntity mapToEventEntity(EventPlaceRegister eventPlaceRegister) {
        return EventHistoryEntity.builder()
                .name(eventPlaceRegister.name())
                .createdAt(dateProvider.dateNow())
                .places(eventPlaceRegister.joinBookedPlaces())
                .build();

    }

}
