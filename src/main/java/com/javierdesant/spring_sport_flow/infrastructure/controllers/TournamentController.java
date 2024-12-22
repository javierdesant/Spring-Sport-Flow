package com.javierdesant.spring_sport_flow.infrastructure.controllers;

import com.javierdesant.spring_sport_flow.api.dto.requests.TournamentRequest;
import com.javierdesant.spring_sport_flow.api.dto.responses.TournamentResponse;
import com.javierdesant.spring_sport_flow.infrastructure.services.contracts.ITournamentService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tournaments")
@AllArgsConstructor
public class TournamentController {
    private final ITournamentService tournamentService;

    @PostMapping
    public ResponseEntity<TournamentResponse> post(@Valid @RequestBody TournamentRequest request) {
        return ResponseEntity.ok(tournamentService.create(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TournamentResponse> getOne(@PathVariable Long id) {
        return ResponseEntity.ok(tournamentService.read(id));
    }

    @GetMapping
    public ResponseEntity<Page<TournamentResponse>> getAll(@PageableDefault Pageable pageable) {
        return ResponseEntity.ok(tournamentService.listAll(pageable));
    }

}
