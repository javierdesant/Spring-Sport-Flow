package com.javierdesant.spring_sport_flow.infrastructure.services.auth;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class JwtService {
    public String generateToken(UserDetails user) {
        return "token"; // TODO
    }
}
