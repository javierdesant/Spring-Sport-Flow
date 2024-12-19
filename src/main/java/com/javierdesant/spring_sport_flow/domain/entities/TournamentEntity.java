package com.javierdesant.spring_sport_flow.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Entity(name = "tournaments")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class TournamentEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 150, unique = true, nullable = false)
    private String name;

    @Column(nullable = false)
    private LocalDate startDate;

    @Column(nullable = false)
    private LocalDate endDate;

    @ManyToOne
    @JoinColumn(name = "league_code", nullable = false)
    private LeagueEntity league;

    @ManyToOne
    @JoinColumn(name = "sport_code", nullable = false)
    private SportEntity sport;

    @ManyToOne
    @JoinColumn(name = "category_code", nullable = false)
    private CategoryEntity category;

}
