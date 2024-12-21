package com.javierdesant.spring_sport_flow.api.dto.responses;

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
public class PlayerResponse extends UserResponse {  // TODO: revisar
    private String firstName;
    private String lastName;
    private String dni;
    private AdminResponse admin;
    private Set<TeamResponse> teams;
}
