package com.javierdesant.spring_sport_flow.infrastructure.config.security.filter;

import com.javierdesant.spring_sport_flow.infrastructure.services.PlayerService;
import com.javierdesant.spring_sport_flow.infrastructure.services.internal.JwtTokenService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private final JwtTokenService jwtTokenService;
    private final PlayerService playerService;

    public JwtAuthenticationFilter(JwtTokenService jwtTokenService, PlayerService playerService) {
        this.jwtTokenService = jwtTokenService;
        this.playerService = playerService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull FilterChain filterChain) throws ServletException, IOException {

        String authorizationHeader = request.getHeader("Authorization");
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
        }

        assert authorizationHeader != null;
        String jwt = authorizationHeader.split(" ")[1];

        String username = jwtTokenService.extractUsername(jwt);

        UserDetails userDetails = playerService.findOneByUsername(username)
                .orElseThrow(EntityNotFoundException::new);

        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                username, null, userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authToken);

        filterChain.doFilter(request, response);
    }
}
