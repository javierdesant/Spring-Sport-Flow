package com.javierdesant.spring_sport_flow.api.dto.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.Getter;

import java.util.Arrays;

public class UpmEmailValidator implements ConstraintValidator<UpmEmail, String> {

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        if (email == null || email.isBlank()) {
            return false;
        }
        return UpmEmailDomain.belongsToUpmDomain(email);
    }

    @Getter
    private enum UpmEmailDomain {
        UPM_ES("@upm.es"),
        UPM_ALUMNOS_ES("@alumnos.upm.es");

        private final String suffix;

        UpmEmailDomain(String suffix) {
            this.suffix = suffix;
        }

        public static boolean belongsToUpmDomain(String email) {
            return Arrays.stream(values())
                    .anyMatch(domain -> email.endsWith(domain.getSuffix()));
        }
    }
}