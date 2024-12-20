package com.javierdesant.spring_sport_flow.domain.entities;

import com.javierdesant.spring_sport_flow.utils.TimeFrame;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

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

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "startDate", column = @Column(nullable = false)),
            @AttributeOverride(name = "endDate", column = @Column(nullable = false))
    })
    private TimeFrame timeFrame;

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
