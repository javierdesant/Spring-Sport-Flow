package com.javierdesant.spring_sport_flow.utils.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.HashMap;
import java.util.Map;

public class NationalIdValidatorDelegator implements ConstraintValidator<NationalId, String> {

    private static final Map<String, NationalIdValidator> VALIDATORS;

    private String country;

    static {
        VALIDATORS = new HashMap<>();
        VALIDATORS.put("INTL", new DefaultNationalIdValidator());
        VALIDATORS.put("ES", new DniValidator());
    }

    @Override
    public void initialize(NationalId constraintAnnotation) {
        this.country = constraintAnnotation.country();
    }

    @Override
    public boolean isValid(String nationalId, ConstraintValidatorContext context) {
        NationalIdValidator validator = VALIDATORS.getOrDefault(
                country.toUpperCase(),
                VALIDATORS.get("INTL")
        );

        return validator.isValid(nationalId, context);
    }
}