package com.javierdesant.spring_sport_flow.api.dto.requests;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
public class AdminRequest extends UserRequest {
}
