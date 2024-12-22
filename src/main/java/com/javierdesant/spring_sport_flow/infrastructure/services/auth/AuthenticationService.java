package com.javierdesant.spring_sport_flow.infrastructure.services.auth;

import com.javierdesant.spring_sport_flow.api.dto.mappers.PlayerMapper;
import com.javierdesant.spring_sport_flow.api.dto.requests.PlayerRequest;
import com.javierdesant.spring_sport_flow.api.dto.responses.PlayerResponse;
import com.javierdesant.spring_sport_flow.domain.entities.PlayerEntity;
import com.javierdesant.spring_sport_flow.infrastructure.services.PlayerService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthenticationService {

    private final PlayerService playerService;
    private final JwtService jwtService;
    private final PlayerMapper playerMapper;

    public AuthenticationService(PlayerService playerService, JwtService jwtService, PlayerMapper playerMapper) {
        this.playerService = playerService;
        this.jwtService = jwtService;
        this.playerMapper = playerMapper;
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
}
