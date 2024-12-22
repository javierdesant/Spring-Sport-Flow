package com.javierdesant.spring_sport_flow.utils;

import lombok.Getter;

import java.util.List;

@Getter
public enum Role {

    ADMIN(List.of(
            RolePermission.VIEW_TOURNAMENTS,
            RolePermission.CREATE_PLAYER,
            RolePermission.DELETE_PLAYER,
            RolePermission.CREATE_TEAM,
            RolePermission.DELETE_TEAM,
            RolePermission.ADD_PLAYER_TO_TEAM,
            RolePermission.REMOVE_PLAYER_FROM_TEAM,
            RolePermission.CREATE_TOURNAMENT,
            RolePermission.DELETE_TOURNAMENT,
            RolePermission.RUN_MATCHMAKING,
            RolePermission.VIEW_TOURNAMENTS_WITH_RANKINGS
    )),

    PLAYER(List.of(
            RolePermission.VIEW_TOURNAMENTS,
            RolePermission.JOIN_TOURNAMENT,
            RolePermission.LEAVE_TOURNAMENT,
            RolePermission.VIEW_PLAYER_STATS
    ));

    private final List<RolePermission> permissions;

    Role(List<RolePermission> permissions) {
        this.permissions = permissions;
    }

}