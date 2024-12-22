package com.javierdesant.spring_sport_flow.infrastructure.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class HttpSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, AuthenticationProvider daoAuthenticationProvider) throws Exception {
        SecurityFilterChain filterChain;

        filterChain = http
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(sessMagConfig -> sessMagConfig.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(daoAuthenticationProvider)
                .authorizeHttpRequests(authReqConfig -> {
                    authReqConfig.requestMatchers(HttpMethod.GET, "/tournaments/**").permitAll();
                    authReqConfig.requestMatchers(HttpMethod.POST, "/auth/**").permitAll();
                    authReqConfig.anyRequest().authenticated();
                })
                .build();

        return filterChain;
    }
}