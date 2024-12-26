package com.javierdesant.spring_sport_flow.utils;

import lombok.Getter;

import java.util.List;

@Getter
public enum Role {

    ADMIN(List.of(
            RolePermission.MANAGE_PLAYERS,
            RolePermission.MANAGE_TEAMS,
            RolePermission.MANAGE_TOURNAMENTS,
            RolePermission.RUN_MATCHMAKING
    )),

    PLAYER(List.of(
            RolePermission.JOIN_TOURNAMENTS,
            RolePermission.MANAGE_PERSONAL_ACCOUNT
    ));

    private final List<RolePermission> permissions;

    Role(List<RolePermission> permissions) {
        this.permissions = permissions;
    }

}