package com.javierdesant.spring_sport_flow.domain.repositories;

import com.javierdesant.spring_sport_flow.domain.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserDetails> findByEmail(String username);
}
