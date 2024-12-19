package com.javierdesant.spring_sport_flow.domain.repositories;

import com.javierdesant.spring_sport_flow.domain.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
