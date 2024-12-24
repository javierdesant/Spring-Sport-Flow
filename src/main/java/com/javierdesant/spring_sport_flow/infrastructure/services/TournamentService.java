package com.javierdesant.spring_sport_flow.infrastructure.services;

import com.javierdesant.spring_sport_flow.api.dto.requests.TournamentRequest;
import com.javierdesant.spring_sport_flow.domain.entities.TournamentEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TournamentService extends CrudService<TournamentRequest, TournamentEntity, Long> {
    Page<TournamentEntity> listAll(Pageable pageable);
}
