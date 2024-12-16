package com.javierdesant.spring_sport_flow.domain.enums;

public enum Role {
    ADMIN,
    PLAYER,

    GUEST;

    public boolean isGuest() {
        return this == GUEST;
    }
}
