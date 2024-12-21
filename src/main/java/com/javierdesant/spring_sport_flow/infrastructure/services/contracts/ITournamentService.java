package com.javierdesant.spring_sport_flow.infrastructure.services.contracts;

import com.javierdesant.spring_sport_flow.api.dto.requests.TournamentRequest;
import com.javierdesant.spring_sport_flow.api.dto.responses.TournamentResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ITournamentService extends CrudService<TournamentRequest, TournamentResponse, Long> {
    Page<TournamentResponse> listAll(Pageable pageable);
}
