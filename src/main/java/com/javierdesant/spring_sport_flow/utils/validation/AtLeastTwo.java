package com.javierdesant.spring_sport_flow.utils.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = AtLeastTwoValidator.class)
public @interface AtLeastTwo {
    String message() default "The set must contain at least two player IDs.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
