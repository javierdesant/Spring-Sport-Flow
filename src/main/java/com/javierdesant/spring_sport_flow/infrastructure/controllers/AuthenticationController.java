package com.javierdesant.spring_sport_flow.infrastructure.controllers;

import com.javierdesant.spring_sport_flow.api.dto.auth.AuthenticationRequest;
import com.javierdesant.spring_sport_flow.api.dto.auth.AuthenticationResponse;
import com.javierdesant.spring_sport_flow.infrastructure.services.internal.AuthenticationServiceImpl;
import com.javierdesant.spring_sport_flow.infrastructure.services.TokenService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private final AuthenticationServiceImpl authenticationService;
    private final TokenService tokenService;

    public AuthenticationController(AuthenticationServiceImpl authenticationService, TokenService tokenService) {
        this.authenticationService = authenticationService;
        this.tokenService = tokenService;
    }

    @GetMapping("/validate-token")
    public ResponseEntity<Boolean> validate(@RequestParam String jwt) {
        boolean isValidToken = tokenService.validateToken(jwt);
        return ResponseEntity.ok(isValidToken);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody @Valid AuthenticationRequest request) {

        AuthenticationResponse response = authenticationService.login(request);
        return ResponseEntity.ok(response);
    }
}
