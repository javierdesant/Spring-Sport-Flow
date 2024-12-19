package com.javierdesant.spring_sport_flow.domain.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "registrations")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegistrationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "registration_id")
    private Long registrationId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tournament_id", nullable = false)
    private TournamentEntity tournament;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "player_id")
    private PlayerEntity player;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private TeamEntity team;

    @PrePersist
    @PreUpdate
    private void validateRegistration() {
        if ((player == null && team == null) || (player != null && team != null)) {
            throw new IllegalStateException();
        }
    }
}