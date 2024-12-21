package com.javierdesant.spring_sport_flow.api.dto.responses;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class SportResponse implements Serializable {
    private String sportCode;
    private String sportName;
    private Set<TournamentResponse> tournaments;
}
