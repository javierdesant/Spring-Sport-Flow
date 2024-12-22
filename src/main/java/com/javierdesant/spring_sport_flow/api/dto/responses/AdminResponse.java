package com.javierdesant.spring_sport_flow.api.dto.responses;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
public class AdminResponse extends UserResponse {
}
