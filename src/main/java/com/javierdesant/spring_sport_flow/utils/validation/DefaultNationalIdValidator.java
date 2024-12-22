package com.javierdesant.spring_sport_flow.utils.validation;

public class DefaultNationalIdValidator extends NationalIdValidator {
    @Override
    protected String getRegex() {
        return "\\d{8}";
    }
}