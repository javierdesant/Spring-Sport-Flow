package com.javierdesant.spring_sport_flow.api.dto.requests;

import lombok.*;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
public class PlayerRequest extends UserRequest {
    private String firstName;
    private String lastName;
    private String dni;
    private Long adminId;
}
