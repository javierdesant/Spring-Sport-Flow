package com.javierdesant.spring_sport_flow.infrastructure.config.security;

import com.javierdesant.spring_sport_flow.infrastructure.config.security.filter.JwtAuthenticationFilter;
import com.javierdesant.spring_sport_flow.utils.RolePermission;
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
        http.csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(sessMagConfig ->
                        sessMagConfig.sessionCreationPolicy(this.sessionPolicy))
                .authenticationProvider(daoAuthenticationProvider)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .authorizeHttpRequests(this::buildRequestMatchers);

        return http.build();
    }

    private void buildRequestMatchers(AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry authReqConfig) {
        this.configurePublicEndpoints(authReqConfig);
        this.configurePlayerEndpoints(authReqConfig);
        this.configureTeamEndpoints(authReqConfig);
        this.configureTournamentEndpoints(authReqConfig);
        this.configurePersonalAccountEndpoints(authReqConfig);

        authReqConfig.anyRequest().authenticated();
    }

    private void configurePublicEndpoints(AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry authReqConfig) {
        authReqConfig.requestMatchers(HttpMethod.GET, "/tournaments/**").permitAll();
        authReqConfig.requestMatchers(HttpMethod.POST, "/auth/authenticate").permitAll();
        authReqConfig.requestMatchers(HttpMethod.GET, "/auth/validate-token").permitAll();
    }

    private void configurePlayerEndpoints(AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry authReqConfig) {
        authReqConfig.requestMatchers(HttpMethod.POST, "/players").hasAuthority(RolePermission.MANAGE_PLAYERS.name());
        authReqConfig.requestMatchers(HttpMethod.DELETE, "/players/{playerId}").hasAuthority(RolePermission.MANAGE_PLAYERS.name());
        authReqConfig.requestMatchers(HttpMethod.PUT, "/players/{playerId}/stats").hasAuthority(RolePermission.MANAGE_PLAYERS.name());
    }

    private void configureTeamEndpoints(AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry authReqConfig) {
        authReqConfig.requestMatchers(HttpMethod.POST, "/teams").hasAuthority(RolePermission.MANAGE_TEAMS.name());
        authReqConfig.requestMatchers(HttpMethod.DELETE, "/teams/{teamId}").hasAuthority(RolePermission.MANAGE_TEAMS.name());
        authReqConfig.requestMatchers(HttpMethod.POST, "/teams/{teamId}/members").hasAuthority(RolePermission.MANAGE_TEAMS.name());
        authReqConfig.requestMatchers(HttpMethod.DELETE, "/teams/{teamId}/members/{playerId}").hasAuthority(RolePermission.MANAGE_TEAMS.name());
    }

    private void configureTournamentEndpoints(AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry authReqConfig) {
        authReqConfig.requestMatchers(HttpMethod.POST, "/tournaments").hasAuthority(RolePermission.MANAGE_TOURNAMENTS.name());
        authReqConfig.requestMatchers(HttpMethod.DELETE, "/tournaments/{tournamentId}").hasAuthority(RolePermission.MANAGE_TOURNAMENTS.name());
        authReqConfig.requestMatchers(HttpMethod.POST, "/tournaments/{tournamentId}/matches/randomize").hasAuthority(RolePermission.MANAGE_TOURNAMENTS.name());
        authReqConfig.requestMatchers(HttpMethod.POST, "/tournaments/{tournamentId}/matches").hasAuthority(RolePermission.MANAGE_TOURNAMENTS.name());
        authReqConfig.requestMatchers(HttpMethod.PUT, "/tournaments/{tournamentId}/matches/{matchId}").hasAuthority(RolePermission.MANAGE_TOURNAMENTS.name());
        authReqConfig.requestMatchers(HttpMethod.DELETE, "/tournaments/{tournamentId}/matches/{matchId}").hasAuthority(RolePermission.MANAGE_TOURNAMENTS.name());
        authReqConfig.requestMatchers(HttpMethod.POST, "/tournament/{tournamentId}/join").hasAuthority(RolePermission.JOIN_TOURNAMENTS.name());
        authReqConfig.requestMatchers(HttpMethod.DELETE, "/tournament/{tournamentId}/leave").hasAuthority(RolePermission.JOIN_TOURNAMENTS.name());
    }

    private void configurePersonalAccountEndpoints(AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry authReqConfig) {
        authReqConfig.requestMatchers(HttpMethod.GET, "/players/me/**").hasAuthority(RolePermission.MANAGE_PERSONAL_ACCOUNT.name());
        authReqConfig.requestMatchers(HttpMethod.PUT, "/players/me").hasAuthority(RolePermission.MANAGE_PERSONAL_ACCOUNT.name());
    }
}