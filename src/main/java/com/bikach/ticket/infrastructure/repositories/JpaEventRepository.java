package com.bikach.ticket.infrastructure.repositories;

import com.bikach.ticket.infrastructure.repositories.entity.EventHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface JpaEventRepository extends JpaRepository<EventHistoryEntity, UUID> {

}
