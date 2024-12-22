package com.javierdesant.spring_sport_flow.infrastructure.services.auth;

import com.javierdesant.spring_sport_flow.api.dto.mappers.PlayerMapper;
import com.javierdesant.spring_sport_flow.api.dto.requests.PlayerRequest;
import com.javierdesant.spring_sport_flow.api.dto.responses.PlayerResponse;
import com.javierdesant.spring_sport_flow.domain.entities.PlayerEntity;
import com.javierdesant.spring_sport_flow.infrastructure.services.PlayerService;
import org.springframework.stereotype.Service;

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
        String jwt = jwtService.generateToken(player);

        PlayerResponse response = playerMapper.toPlayerResponse(player);
        response.setJwt(jwt);

        return response;
    }
}
