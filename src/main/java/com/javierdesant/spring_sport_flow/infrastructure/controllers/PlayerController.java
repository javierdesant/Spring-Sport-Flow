package com.javierdesant.spring_sport_flow.infrastructure.controllers;

import com.javierdesant.spring_sport_flow.api.dto.mappers.PlayerMapper;
import com.javierdesant.spring_sport_flow.api.dto.requests.PlayerRequest;
import com.javierdesant.spring_sport_flow.api.dto.responses.PlayerResponse;
import com.javierdesant.spring_sport_flow.domain.entities.AdminEntity;
import com.javierdesant.spring_sport_flow.domain.entities.PlayerEntity;
import com.javierdesant.spring_sport_flow.domain.entities.UserEntity;
import com.javierdesant.spring_sport_flow.infrastructure.config.security.annotations.IsAdmin;
import com.javierdesant.spring_sport_flow.infrastructure.config.security.annotations.IsPlayer;
import com.javierdesant.spring_sport_flow.infrastructure.services.AuthenticationService;
import com.javierdesant.spring_sport_flow.infrastructure.services.PlayerService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/players")
@AllArgsConstructor
public class PlayerController {
    private final AuthenticationService authenticationService;
    private final PlayerMapper playerMapper;
    private final PlayerService playerService;

    @PostMapping
    @IsAdmin
    public ResponseEntity<PlayerResponse> register(@AuthenticationPrincipal AdminEntity admin,
                                                   @RequestBody @Valid PlayerRequest request) {
        request.setAdminId(admin.getUserId());
        PlayerResponse registeredPlayer = authenticationService.register(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(registeredPlayer);
    }

    @GetMapping("/me")
    @IsPlayer
    public ResponseEntity<PlayerResponse> profile() {
        UserEntity user = authenticationService.findLoggedInUser();
        if (user instanceof PlayerEntity player) {
            PlayerResponse response = playerMapper.toPlayerResponse(player);
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    @IsAdmin
    public ResponseEntity<Page<PlayerResponse>> getAll(@PageableDefault Pageable pageable) {
        Page<PlayerResponse> responsePage = playerService.listAll(pageable)
                .map(playerMapper::toPlayerResponse);
        return ResponseEntity.ok(responsePage);
    }
}
