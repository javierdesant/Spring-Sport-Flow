package com.javierdesant.spring_sport_flow.api.dto.responses;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class LeagueResponse implements Serializable {
    private String leagueCode;
    private String leagueName;
    private Set<TournamentResponse> tournaments;
}
