package com.javierdesant.spring_sport_flow.api.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CategoryResponse implements Serializable {
    private String categoryCode;
    private String categoryName;
    private Set<TournamentResponse> tournaments;
    private Set<StatisticResponse> statistics;
}
