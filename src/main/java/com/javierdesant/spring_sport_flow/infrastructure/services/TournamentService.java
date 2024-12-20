package com.javierdesant.spring_sport_flow.infrastructure.services;

import com.javierdesant.spring_sport_flow.api.dto.requests.TournamentRequest;
import com.javierdesant.spring_sport_flow.api.dto.responses.TournamentResponse;
import com.javierdesant.spring_sport_flow.infrastructure.services.contracts.ITournamentService;

public class TournamentService implements ITournamentService {
    @Override
    public TournamentResponse create(TournamentRequest request) {
        return null;
    }

    @Override
    public TournamentResponse read(Long aLong) {
        return null;
    }

    @Override
    public TournamentResponse update(TournamentRequest request, Long aLong) {
        return null;
    }

    @Override
    public void delete(Long aLong) {

    }
}
