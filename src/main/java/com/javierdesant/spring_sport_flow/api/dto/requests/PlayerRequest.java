package com.javierdesant.spring_sport_flow.api.dto.requests;

import com.javierdesant.spring_sport_flow.utils.validation.NationalId;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
public class PlayerRequest extends UserRequest {
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NationalId(country = "ES")
    private String dni;
//    private Long adminId;
}
