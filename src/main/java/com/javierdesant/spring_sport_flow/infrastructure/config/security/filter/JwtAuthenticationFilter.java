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
import org.springframework.security.web.authentication.WebAuthenticationDetails;
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

        if (!isHeaderValid(authorizationHeader)) {
            filterChain.doFilter(request, response);
            return;
        }

        String jwt = this.extractJwt(authorizationHeader);
        String username = jwtTokenService.extractUsername(jwt);

        UserDetails userDetails = this.fetchUserDetails(username);
        this.authenticateUser(request, userDetails);

        filterChain.doFilter(request, response);
    }

    private boolean isHeaderValid(String authorizationHeader) {
        return authorizationHeader != null && authorizationHeader.startsWith("Bearer ");
    }

    private String extractJwt(String authorizationHeader) {
        return authorizationHeader.split(" ")[1];
    }

    private UserDetails fetchUserDetails(String username) {
        return playerService.findOneByUsername(username)
                .orElseThrow(EntityNotFoundException::new);
    }

    private void authenticateUser(HttpServletRequest request, UserDetails userDetails) {
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                userDetails.getUsername(), null, userDetails.getAuthorities()
        );
        authToken.setDetails(new WebAuthenticationDetails(request));
        SecurityContextHolder.getContext().setAuthentication(authToken);
    }
}
