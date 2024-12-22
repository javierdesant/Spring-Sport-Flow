package com.javierdesant.spring_sport_flow.utils.validation;

import jakarta.validation.ConstraintValidatorContext;

public class DniValidator extends NationalIdValidator {
    @Override
    public boolean isValid(String nationalId, ConstraintValidatorContext context) {
        return super.isValid(nationalId, context) && isValidLetter(nationalId);
    }

    @Override
    protected String getRegex() {
        return "\\d{8}[A-Z]";
    }

    private boolean isValidLetter(String nationalId) {
        String digitsPart = nationalId.substring(0, 8);
        char letter = nationalId.charAt(8);

        String validLetters = "TRWAGMYFPDXBNJZSQVHLCKE";
        int number = Integer.parseInt(digitsPart);
        char expectedLetter = validLetters.charAt(number % validLetters.length());

        return letter == expectedLetter;
    }
}