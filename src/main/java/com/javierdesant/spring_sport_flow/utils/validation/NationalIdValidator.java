package com.javierdesant.spring_sport_flow.utils.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public abstract class NationalIdValidator implements ConstraintValidator<NationalId, String> {
    @Override
    public boolean isValid(String nationalId, ConstraintValidatorContext context) {
        if (nationalId == null) {
            return true;
        }

        return nationalId.matches(this.getRegex());
    }

    protected abstract String getRegex();
}