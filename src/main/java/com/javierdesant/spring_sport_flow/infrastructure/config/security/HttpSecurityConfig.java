package com.javierdesant.spring_sport_flow.infrastructure.config.security;

import com.javierdesant.spring_sport_flow.infrastructure.config.security.filter.JwtAuthenticationFilter;
import com.javierdesant.spring_sport_flow.utils.RolePermission;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class HttpSecurityConfig {

    private final SessionCreationPolicy sessionPolicy = SessionCreationPolicy.STATELESS;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http,
                                                   AuthenticationProvider daoAuthenticationProvider,
                                                   JwtAuthenticationFilter jwtAuthenticationFilter) throws Exception {

        this.configureHttpSecurity(http, daoAuthenticationProvider, jwtAuthenticationFilter);
        return http.build();
    }

    private void configureHttpSecurity(HttpSecurity http,
                                       AuthenticationProvider daoAuthenticationProvider,
                                       JwtAuthenticationFilter jwtAuthenticationFilter) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(sessMagConfig ->
                        sessMagConfig.sessionCreationPolicy(this.sessionPolicy))
                .authenticationProvider(daoAuthenticationProvider)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .authorizeHttpRequests(this::configureAuthorizationRules);
    }

    private void configureAuthorizationRules(AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry authReqConfig) {
        configurePublicEndpoints(authReqConfig);

        for (EndpointConfig config : EndpointConfig.values()) {
            authReqConfig
                    .requestMatchers(config.getMethod(), config.getPath())
                    .hasAuthority(config.getPermission().name());
        }

        authReqConfig.anyRequest().authenticated();
    }

    private void configurePublicEndpoints(AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry authReqConfig) {
        authReqConfig.requestMatchers(HttpMethod.GET, "/tournaments/**").permitAll();
        authReqConfig.requestMatchers(HttpMethod.POST, "/auth/authenticate").permitAll();
        authReqConfig.requestMatchers(HttpMethod.GET, "/auth/validate-token").permitAll();
    }

    @Getter
    @AllArgsConstructor
    private enum EndpointConfig {
        CREATE_PLAYER(HttpMethod.POST, "/players", RolePermission.MANAGE_PLAYERS),
        DELETE_PLAYER(HttpMethod.DELETE, "/players/{playerId}", RolePermission.MANAGE_PLAYERS),
        UPDATE_PLAYER_STATS(HttpMethod.PUT, "/players/{playerId}/stats", RolePermission.MANAGE_PLAYERS),

        CREATE_TEAM(HttpMethod.POST, "/teams", RolePermission.MANAGE_TEAMS),
        DELETE_TEAM(HttpMethod.DELETE, "/teams/{teamId}", RolePermission.MANAGE_TEAMS),
        ADD_TEAM_MEMBER(HttpMethod.POST, "/teams/{teamId}/members", RolePermission.MANAGE_TEAMS),
        REMOVE_TEAM_MEMBER(HttpMethod.DELETE, "/teams/{teamId}/members/{playerId}", RolePermission.MANAGE_TEAMS),

        CREATE_TOURNAMENT(HttpMethod.POST, "/tournaments", RolePermission.MANAGE_TOURNAMENTS),
        DELETE_TOURNAMENT(HttpMethod.DELETE, "/tournaments/{tournamentId}", RolePermission.MANAGE_TOURNAMENTS),
        RANDOMIZE_MATCHES(HttpMethod.POST, "/tournaments/{tournamentId}/matches/randomize", RolePermission.MANAGE_TOURNAMENTS),
        CREATE_MATCH(HttpMethod.POST, "/tournaments/{tournamentId}/matches", RolePermission.MANAGE_TOURNAMENTS),
        UPDATE_MATCH(HttpMethod.PUT, "/tournaments/{tournamentId}/matches/{matchId}", RolePermission.MANAGE_TOURNAMENTS),
        DELETE_MATCH(HttpMethod.DELETE, "/tournaments/{tournamentId}/matches/{matchId}", RolePermission.MANAGE_TOURNAMENTS),

        JOIN_TOURNAMENT(HttpMethod.POST, "/tournament/{tournamentId}/join", RolePermission.JOIN_TOURNAMENTS),
        LEAVE_TOURNAMENT(HttpMethod.DELETE, "/tournament/{tournamentId}/leave", RolePermission.JOIN_TOURNAMENTS),

        VIEW_PERSONAL_STATS(HttpMethod.GET, "/players/me/**", RolePermission.MANAGE_PERSONAL_ACCOUNT),
        UPDATE_PERSONAL_DATA(HttpMethod.PUT, "/players/me", RolePermission.MANAGE_PERSONAL_ACCOUNT);

        private final HttpMethod method;
        private final String path;
        private final RolePermission permission;

    }
}