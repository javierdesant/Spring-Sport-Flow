package com.javierdesant.spring_sport_flow.infrastructure.services.auth;

import com.javierdesant.spring_sport_flow.api.dto.requests.PlayerRequest;
import com.javierdesant.spring_sport_flow.api.dto.responses.PlayerResponse;
import com.javierdesant.spring_sport_flow.domain.entities.PlayerEntity;
import com.javierdesant.spring_sport_flow.infrastructure.services.PlayerService;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private final PlayerService playerService;
    private final JwtService jwtService;

    public AuthenticationService(PlayerService playerService, JwtService jwtService) {
        this.playerService = playerService;
        this.jwtService = jwtService;
    }

    public PlayerResponse register(PlayerRequest request) {
        PlayerEntity player = playerService.create(request);
        String jwt = jwtService.generateToken(player);    // FIXME

        // TODO: player mapper to response
        PlayerResponse response = new PlayerResponse();

        response.setJwt(jwt);

        return response;
    }
}
