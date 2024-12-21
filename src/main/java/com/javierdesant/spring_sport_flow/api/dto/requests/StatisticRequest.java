package com.javierdesant.spring_sport_flow.api.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class StatisticRequest implements Serializable {
    private Long playerId;
    private String categoryCode;
    private BigDecimal value;
}
