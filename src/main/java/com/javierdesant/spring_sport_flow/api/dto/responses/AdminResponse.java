package com.javierdesant.spring_sport_flow.api.dto.responses;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
public class AdminResponse extends UserResponse {
    private Set<Long> managedTeamIds;
}
