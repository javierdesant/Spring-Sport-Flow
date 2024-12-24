package com.javierdesant.spring_sport_flow.infrastructure.services;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.Map;

public interface TokenService {
    String generateToken(UserDetails user, Map<String, Object> extraClaims);

    String extractUsername(String jwt);

    boolean validateToken(String jwt);
}
