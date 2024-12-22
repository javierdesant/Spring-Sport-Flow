package com.javierdesant.spring_sport_flow.infrastructure.services.auth;

import com.javierdesant.spring_sport_flow.api.dto.auth.AuthenticationRequest;
import com.javierdesant.spring_sport_flow.api.dto.auth.AuthenticationResponse;
import com.javierdesant.spring_sport_flow.api.dto.mappers.PlayerMapper;
import com.javierdesant.spring_sport_flow.api.dto.requests.PlayerRequest;
import com.javierdesant.spring_sport_flow.api.dto.responses.PlayerResponse;
import com.javierdesant.spring_sport_flow.domain.entities.PlayerEntity;
import com.javierdesant.spring_sport_flow.infrastructure.services.PlayerService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthenticationService {

    private final PlayerService playerService;
    private final JwtService jwtService;
    private final PlayerMapper playerMapper;
    private final AuthenticationManager authenticationManager;

    public AuthenticationService(PlayerService playerService, JwtService jwtService, PlayerMapper playerMapper, AuthenticationManager authenticationManager) {
        this.playerService = playerService;
        this.jwtService = jwtService;
        this.playerMapper = playerMapper;
        this.authenticationManager = authenticationManager;
    }

    public PlayerResponse register(PlayerRequest request) {
        PlayerEntity player = playerService.create(request);
        String jwt = jwtService.generateToken(player, generateExtraClaims(player));

        PlayerResponse response = playerMapper.toPlayerResponse(player);
        response.setJwt(jwt);

        return response;
    }

    private Map<String, Object> generateExtraClaims(PlayerEntity player) {
        Map<String, Object> extraClaims = new HashMap<>();
        extraClaims.put("name", player.getFullName());
        extraClaims.put("authorities", player.getAuthorities());

        return extraClaims;
    }

    public AuthenticationResponse login(AuthenticationRequest request) {

        Authentication authentication = new UsernamePasswordAuthenticationToken(
                request.getUsername(), request.getPassword()
        );

        authenticationManager.authenticate(authentication);

        // FIXME!: the login only contemplates players
        PlayerEntity player = playerService.findOneByUsername(request.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("Player not found"));
        String jwt = jwtService.generateToken(player, generateExtraClaims(player));

        return new AuthenticationResponse(jwt);
    }
}
