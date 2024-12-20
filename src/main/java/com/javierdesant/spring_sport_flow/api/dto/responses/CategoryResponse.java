package com.javierdesant.spring_sport_flow.api.dto.responses;

import com.javierdesant.spring_sport_flow.domain.entities.StatisticEntity;
import com.javierdesant.spring_sport_flow.domain.entities.TournamentEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
public class CategoryResponse extends BaseCodeResponse {
    private Set<TournamentEntity> tournaments;
    private Set<StatisticEntity> statistics;
}
