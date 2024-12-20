package com.javierdesant.spring_sport_flow.api.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class TournamentResponse implements Serializable {
    private Long id;
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private LeagueResponse league;
    private SportResponse sport;
    private CategoryResponse category;
}
