package com.javierdesant.spring_sport_flow.api.dto.responses;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
public class PlayerResponse extends UserResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String dni;
    private String email;
    private Long adminId;
    private Set<Long> teamIds;
}
