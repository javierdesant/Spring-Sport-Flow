package com.javierdesant.spring_sport_flow.infrastructure.services.internal;

import com.javierdesant.spring_sport_flow.api.dto.requests.PlayerRequest;
import com.javierdesant.spring_sport_flow.domain.entities.PlayerEntity;
import com.javierdesant.spring_sport_flow.domain.repositories.PlayerRepository;
import com.javierdesant.spring_sport_flow.infrastructure.services.PlayerService;
import com.javierdesant.spring_sport_flow.infrastructure.services.exceptions.InvalidPasswordException;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
@Service
@Slf4j
@AllArgsConstructor
public class PlayerServiceImpl implements PlayerService {
    private final PlayerRepository playerRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public PlayerEntity create(PlayerRequest request) {
        this.validatePasswords(request);
        String encodedPassword = passwordEncoder.encode(request.getPassword());

        // TODO: add .adminId() on register
        PlayerEntity playerToRegister = PlayerEntity.builder()
                .dni(request.getDni())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(encodedPassword)
                .build();

        PlayerEntity savedPlayer = playerRepository.save(playerToRegister);

        log.info("Player '{} {} (ID: {})' saved successfully.",
                savedPlayer.getFirstName(),
                savedPlayer.getLastName(),
                savedPlayer.getUserId());

        return savedPlayer;
    }

    private void validatePasswords(PlayerRequest request) {
        if (!request.getPassword().equals(request.getPasswordConfirmation())) {
            throw new InvalidPasswordException("Passwords do not match");
        }
    }

    @Override
    public PlayerEntity read(Long aLong) {
        return playerRepository.findById(aLong)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public PlayerEntity update(PlayerRequest request, Long aLong) {
        return null;
    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public Optional<PlayerEntity> findOneByUsername(String email) {
        return playerRepository.findByEmail(email);
    }
}
