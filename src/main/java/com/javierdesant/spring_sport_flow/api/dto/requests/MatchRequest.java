package com.javierdesant.spring_sport_flow.api.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class MatchRequest implements Serializable {
    private Long tournamentId;
    private String matchupType;
}