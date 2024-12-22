package com.javierdesant.spring_sport_flow.api.dto.requests;

import jakarta.validation.constraints.NotBlank;
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

    @NotBlank
    private Long tournamentId;

    @NotBlank
    private String matchupType;

}