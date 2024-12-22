package com.javierdesant.spring_sport_flow.api.dto.requests;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
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

    @NotBlank
    private Long playerId;

    @NotBlank
    private String categoryCode;

    @DecimalMin(value = "0.0")
    private BigDecimal value;

}
