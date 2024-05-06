package com.bikach.ticket.infrastructure.repositories;

import com.bikach.ticket.application.domain.EventRepository;
import com.bikach.ticket.application.domain.model.Event;
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
    public void bookPlaces(Event event) {
        var eventEntity = mapToEventEntity(event);
        eventRepository.save(eventEntity);
    }

    private EventHistoryEntity mapToEventEntity(Event event) {
        return EventHistoryEntity.builder()
                .name(event.name())
                .createdAt(dateProvider.dateNow())
                .places(event.joinBookedPlaces())
                .build();

    }

}
