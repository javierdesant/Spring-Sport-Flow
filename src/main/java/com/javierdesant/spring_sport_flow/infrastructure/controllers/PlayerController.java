package com.javierdesant.spring_sport_flow.infrastructure.controllers;

import com.javierdesant.spring_sport_flow.api.dto.mappers.PlayerMapper;
import com.javierdesant.spring_sport_flow.api.dto.requests.PlayerRequest;
import com.javierdesant.spring_sport_flow.api.dto.responses.PlayerResponse;
import com.javierdesant.spring_sport_flow.domain.entities.PlayerEntity;
import com.javierdesant.spring_sport_flow.domain.entities.UserEntity;
import com.javierdesant.spring_sport_flow.infrastructure.services.AuthenticationService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/players")
@AllArgsConstructor
public class PlayerController {

    private final AuthenticationService authenticationService;
    private final PlayerMapper playerMapper;

    @PostMapping
    public ResponseEntity<PlayerResponse> register(@RequestBody @Valid PlayerRequest request) {
        PlayerResponse registeredPlayer = authenticationService.register(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(registeredPlayer);
    }

    @GetMapping("/me")
    public ResponseEntity<PlayerResponse> profile() {
        UserEntity user = authenticationService.findLoggedInUser();
        if (user instanceof PlayerEntity player) {
            PlayerResponse response = playerMapper.toPlayerResponse(player);
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
