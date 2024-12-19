package com.javierdesant.spring_sport_flow.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "matchups")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class MatchEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "tournament_id", nullable = false)
    private TournamentEntity tournament;

    @Column(length = 20, nullable = false)
    private String matchupType;

}