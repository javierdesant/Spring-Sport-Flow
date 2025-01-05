package com.javierdesant.spring_sport_flow.infrastructure.controllers;

import com.javierdesant.spring_sport_flow.api.dto.auth.AuthenticationRequest;
import com.javierdesant.spring_sport_flow.api.dto.auth.AuthenticationResponse;
import com.javierdesant.spring_sport_flow.domain.entities.UserEntity;
import com.javierdesant.spring_sport_flow.infrastructure.config.security.annotations.IsAuthenticated;
import com.javierdesant.spring_sport_flow.infrastructure.config.security.annotations.PermitAllAccess;
import com.javierdesant.spring_sport_flow.infrastructure.services.AuthenticationService;
import com.javierdesant.spring_sport_flow.infrastructure.services.TokenService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final TokenService tokenService;

    @GetMapping("/validate-token")
    @PermitAllAccess
    public ResponseEntity<Boolean> validate(@RequestParam String jwt) {
        boolean isValidToken = tokenService.validateToken(jwt);
        return ResponseEntity.ok(isValidToken);
    }

    @PostMapping("/authenticate")
    @PermitAllAccess
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody @Valid AuthenticationRequest request) {
        AuthenticationResponse response = authenticationService.login(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/profile")
    @IsAuthenticated
    public ResponseEntity<UserEntity> findMyProfile() {
        UserEntity user = authenticationService.findLoggedInUser();
        return ResponseEntity.ok(user);
    }
}
