package com.javierdesant.spring_sport_flow.infrastructure.services.auth;

import com.javierdesant.spring_sport_flow.api.dto.auth.AuthenticationRequest;
import com.javierdesant.spring_sport_flow.api.dto.auth.AuthenticationResponse;
import com.javierdesant.spring_sport_flow.api.dto.requests.PlayerRequest;
import com.javierdesant.spring_sport_flow.api.dto.responses.PlayerResponse;

public interface AuthenticationService {
    PlayerResponse register(PlayerRequest request);

    AuthenticationResponse login(AuthenticationRequest request);
}
