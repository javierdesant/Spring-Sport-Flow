package com.javierdesant.spring_sport_flow.infrastructure.controllers;

import com.javierdesant.spring_sport_flow.api.dto.mappers.TournamentMapper;
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
    private final TournamentMapper mapper;

    @PostMapping
    public ResponseEntity<TournamentResponse> post(@Valid @RequestBody TournamentRequest request) {
        TournamentResponse response = mapper.toResponse(tournamentService.create(request));
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TournamentResponse> getOne(@PathVariable Long id) {
        TournamentResponse response = mapper.toResponse(tournamentService.read(id));
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<Page<TournamentResponse>> getAll(@PageableDefault Pageable pageable) {
        Page<TournamentResponse> responsePage = tournamentService.listAll(pageable)
                .map(mapper::toResponse);
        return ResponseEntity.ok(responsePage);
    }

}
