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
@Builder(toBuilder = true)
public class TournamentResponse implements Serializable {
    private Long tournamentId;
    private String tournamentName;
    private LocalDate startDate;
    private LocalDate endDate;
    private LeagueResponse league;
    private SportResponse sport;
    private CategoryResponse category;
}
