package com.bikach.ticket.infrastructure.repositories.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "EventHistory")
public class EventHistoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;

    @Column
    String name;

    @Column
    LocalDateTime createdAt;

    @Column
    String places;
}
