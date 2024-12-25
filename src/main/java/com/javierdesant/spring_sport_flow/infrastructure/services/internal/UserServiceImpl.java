package com.javierdesant.spring_sport_flow.infrastructure.services.internal;

import com.javierdesant.spring_sport_flow.api.dto.requests.UserRequest;
import com.javierdesant.spring_sport_flow.domain.entities.UserEntity;
import com.javierdesant.spring_sport_flow.domain.repositories.UserRepository;
import com.javierdesant.spring_sport_flow.infrastructure.services.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
@Service
@Slf4j
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public Optional<UserEntity> findOneByUsername(String username) {
        return userRepository.findByUsername(username);
    }


    // TODO
    @Override
    public UserEntity create(UserRequest request) {
        return null;
    }

    @Override
    public UserEntity read(Long aLong) {
        return null;
    }

    @Override
    public UserEntity update(UserRequest request, Long aLong) {
        return null;
    }

    @Override
    public void delete(Long aLong) {

    }
}
