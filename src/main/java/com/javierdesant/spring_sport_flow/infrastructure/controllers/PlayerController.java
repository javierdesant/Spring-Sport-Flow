package com.javierdesant.spring_sport_flow.infrastructure.controllers;

import com.javierdesant.spring_sport_flow.api.dto.requests.PlayerRequest;
import com.javierdesant.spring_sport_flow.api.dto.responses.PlayerResponse;
import com.javierdesant.spring_sport_flow.infrastructure.services.auth.AuthenticationService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/players")
@AllArgsConstructor
public class PlayerController {

    private final AuthenticationService authenticationService;

    @PostMapping
    public ResponseEntity<PlayerResponse> register(@RequestBody @Valid PlayerRequest request) {
        PlayerResponse registeredPlayer = authenticationService.register(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(registeredPlayer);
    }
}
