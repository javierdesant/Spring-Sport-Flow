package com.javierdesant.spring_sport_flow.utils;

import lombok.Getter;

@Getter
public enum RolePermission {

    // Public Permissions
    VIEW_TOURNAMENTS("GET:/tournaments"),
    LOGIN("POST:/auth/login"),
    LOGOUT("POST:/auth/logout"),

    // Player Permissions
    JOIN_TOURNAMENT("POST:/tournaments/{tournamentId}/join"),
    LEAVE_TOURNAMENT("DELETE:/tournaments/{tournamentId}/leave"),
    VIEW_PLAYER_STATS("GET:/players/me/statistics"),

    // Administrator Permissions
    CREATE_PLAYER("POST:/players"),
    DELETE_PLAYER("DELETE:/players/{playerId}"),
    CREATE_TEAM("POST:/teams"),
    DELETE_TEAM("DELETE:/teams/{teamId}"),
    ADD_PLAYER_TO_TEAM("PUT:/teams/{teamId}/add-player/{playerId}"),
    REMOVE_PLAYER_FROM_TEAM("PUT:/teams/{teamId}/remove-player/{playerId}"),
    CREATE_TOURNAMENT("POST:/tournaments"),
    DELETE_TOURNAMENT("DELETE:/tournaments/{tournamentId}"),
    RUN_MATCHMAKING("POST:/tournaments/{tournamentId}/matchmaking"),
    VIEW_TOURNAMENTS_WITH_RANKINGS("GET:/tournaments");

    private final String endpoint;

    RolePermission(String endpoint) {
        this.endpoint = endpoint;
    }

}