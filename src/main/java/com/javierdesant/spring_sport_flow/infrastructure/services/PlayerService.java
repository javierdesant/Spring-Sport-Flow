package com.javierdesant.spring_sport_flow.infrastructure.services;

import com.javierdesant.spring_sport_flow.api.dto.requests.PlayerRequest;
import com.javierdesant.spring_sport_flow.domain.entities.PlayerEntity;
import com.javierdesant.spring_sport_flow.domain.repositories.PlayerRepository;
import com.javierdesant.spring_sport_flow.infrastructure.services.contracts.IPlayerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
@Slf4j
@AllArgsConstructor
public class PlayerService implements IPlayerService {
    private final PlayerRepository playerRepository;

    @Override
    public PlayerEntity create(PlayerRequest request) {

        // TODO: add .adminId() on auth
        PlayerEntity playerToPersist = PlayerEntity.builder()
                .dni(request.getDni())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(request.getPassword())
                .build();

        PlayerEntity savedPlayer = playerRepository.save(playerToPersist);

        log.info("Tournament '{} {} (ID: {})' saved successfully.",
                savedPlayer.getFirstName(),
                savedPlayer.getLastName(),
                savedPlayer.getUserId());

        return savedPlayer;
    }

    @Override
    public PlayerEntity read(Long aLong) {
        return null;
    }

    @Override
    public PlayerEntity update(PlayerRequest request, Long aLong) {
        return null;
    }

    @Override
    public void delete(Long aLong) {

    }
}
