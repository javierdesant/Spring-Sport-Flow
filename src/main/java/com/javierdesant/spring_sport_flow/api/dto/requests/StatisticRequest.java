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
public class StatisticRequest implements Serializable {
    private String statName;
    private Double statValue;
    private Long playerId;
    private String categoryCode;
}
