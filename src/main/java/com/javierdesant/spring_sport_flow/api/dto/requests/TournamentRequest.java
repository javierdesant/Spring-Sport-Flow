package com.javierdesant.spring_sport_flow.api.dto.requests;

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
public class TournamentRequest implements Serializable {
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private String leagueCode;
    private String sportCode;
    private String categoryCode;
}
