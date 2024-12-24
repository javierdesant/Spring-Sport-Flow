package com.javierdesant.spring_sport_flow.infrastructure.config.security;

import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;

public class JwtKeyProvider {

    @Value("${security.jwt.secret-key}")
    private static String SECRET_KEY;

    private JwtKeyProvider() {
    }

    public static SecretKey getSigningKey() {
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));
    }
}
