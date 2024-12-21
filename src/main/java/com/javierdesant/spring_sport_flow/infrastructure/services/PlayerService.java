package com.javierdesant.spring_sport_flow.infrastructure.services;

import com.javierdesant.spring_sport_flow.api.dto.requests.PlayerRequest;
import com.javierdesant.spring_sport_flow.api.dto.responses.PlayerResponse;
import com.javierdesant.spring_sport_flow.domain.entities.PlayerEntity;
import com.javierdesant.spring_sport_flow.domain.repositories.PlayerRepository;
import com.javierdesant.spring_sport_flow.infrastructure.services.contracts.IPlayerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
@Slf4j
@AllArgsConstructor
public class PlayerService implements IPlayerService {
    private final PlayerRepository playerRepository;

    @Override
    public PlayerResponse create(PlayerRequest request) {

        PlayerEntity playerToPersist = PlayerEntity.builder()
                .dni(request.getDni())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(request.getPassword())
                .build();

        // is .adminId() missing ?
        // FIXME: integrate with Spring Security

        PlayerEntity playerPersisted = playerRepository.save(playerToPersist);

        log.info("player saved with id: {}", playerPersisted.getUserId());

        return this.entityToResponse(playerPersisted);
    }

    @Override
    public PlayerResponse read(Long aLong) {
        return null;
    }

    @Override
    public PlayerResponse update(PlayerRequest request, Long aLong) {
        return null;
    }

    @Override
    public void delete(Long aLong) {

    }

    private PlayerResponse entityToResponse(PlayerEntity entity) {
        // FIXME: integrate with Spring Security
        PlayerResponse response = new PlayerResponse();
        BeanUtils.copyProperties(entity, response);
        return response;
    }
}
