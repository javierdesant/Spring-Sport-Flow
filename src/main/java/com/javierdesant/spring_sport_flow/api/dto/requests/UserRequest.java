package com.javierdesant.spring_sport_flow.api.dto.requests;

import com.javierdesant.spring_sport_flow.utils.validation.UpmEmail;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public abstract class UserRequest implements Serializable {
    @UpmEmail
    private String email;
    @NotBlank
    @Size(min = 8)
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).+$")
    private String password;
    private String passwordConfirmation;
}
