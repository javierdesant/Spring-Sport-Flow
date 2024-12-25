package com.javierdesant.spring_sport_flow.infrastructure.services;

import com.javierdesant.spring_sport_flow.api.dto.requests.UserRequest;
import com.javierdesant.spring_sport_flow.domain.entities.UserEntity;

import java.util.Optional;

public interface UserService extends CrudService<UserRequest, UserEntity, Long> {
    Optional<UserEntity> findOneByUsername(String username);
}
