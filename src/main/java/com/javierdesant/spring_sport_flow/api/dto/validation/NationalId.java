package com.javierdesant.spring_sport_flow.api.dto.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NationalIdValidatorDelegator.class)
public @interface NationalId {
    String message() default "The ID is not valid";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String country() default "INTL";
}