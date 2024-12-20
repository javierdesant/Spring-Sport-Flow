package com.javierdesant.spring_sport_flow.infrastructure.services.contracts;

import com.javierdesant.spring_sport_flow.api.dto.requests.TournamentRequest;
import com.javierdesant.spring_sport_flow.api.dto.responses.TournamentResponse;

public interface ITournamentService extends CrudService<TournamentRequest, TournamentResponse, Long> {
}
