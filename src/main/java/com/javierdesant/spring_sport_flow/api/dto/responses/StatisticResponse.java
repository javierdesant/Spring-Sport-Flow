package com.javierdesant.spring_sport_flow.api.dto.responses;

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
public class StatisticResponse implements Serializable {
    private Long statId;
    private PlayerResponse player;
    private CategoryResponse category;
    private BigDecimal value;
}
