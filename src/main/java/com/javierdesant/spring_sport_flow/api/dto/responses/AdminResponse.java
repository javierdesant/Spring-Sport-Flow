package com.javierdesant.spring_sport_flow.api.dto.responses;

import lombok.*;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
@Builder
public class AdminResponse extends UserResponse {
    private Set<Long> managedTeamIds;
}
