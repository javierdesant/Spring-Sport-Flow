package com.javierdesant.spring_sport_flow.infrastructure.services.exceptions;

public class InvalidPasswordException extends RuntimeException {
    public InvalidPasswordException(String message) {
        super(message);
    }
}