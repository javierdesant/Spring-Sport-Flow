package com.javierdesant.spring_sport_flow.infrastructure.services.contracts;

import com.javierdesant.spring_sport_flow.api.dto.requests.PlayerRequest;
import com.javierdesant.spring_sport_flow.domain.entities.PlayerEntity;

import java.util.Optional;

public interface IPlayerService extends CrudService<PlayerRequest, PlayerEntity, Long> {
    Optional<PlayerEntity> findOneByUsername(String username);
}
