package com.javierdesant.spring_sport_flow.utils.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Set;

public class AtLeastTwoValidator implements ConstraintValidator<AtLeastTwo, Set<?>> {

    @Override
    public boolean isValid(Set<?> value, ConstraintValidatorContext context) {
        return value != null && value.size() >= 2;
    }
}
