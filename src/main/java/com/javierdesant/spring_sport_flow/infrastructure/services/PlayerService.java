package com.javierdesant.spring_sport_flow.infrastructure.services;

import com.javierdesant.spring_sport_flow.api.dto.requests.PlayerRequest;
import com.javierdesant.spring_sport_flow.domain.entities.PlayerEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PlayerService extends CrudService<PlayerRequest, PlayerEntity, Long> {
    Page<PlayerEntity> listAll(Pageable pageable);
}
