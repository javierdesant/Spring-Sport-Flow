package com.javierdesant.spring_sport_flow.utils.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.Email;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Email
@Constraint(validatedBy = UpmEmailValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface UpmEmail {

    String message() default "The email must belong to an upm domain";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}