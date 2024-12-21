package com.javierdesant.spring_sport_flow.infrastructure.controllers;

import com.javierdesant.spring_sport_flow.api.dto.requests.TournamentRequest;
import com.javierdesant.spring_sport_flow.api.dto.responses.TournamentResponse;
import com.javierdesant.spring_sport_flow.infrastructure.services.contracts.ITournamentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tournaments")
@AllArgsConstructor
public class TournamentController {
    private final ITournamentService tournamentService;

    @PostMapping
    public ResponseEntity<TournamentResponse> post(@RequestBody TournamentRequest request) {
        return ResponseEntity.ok(tournamentService.create(request));
    }

}
