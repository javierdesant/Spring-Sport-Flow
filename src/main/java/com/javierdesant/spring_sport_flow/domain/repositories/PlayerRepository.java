package com.javierdesant.spring_sport_flow.domain.repositories;

import com.javierdesant.spring_sport_flow.domain.entities.PlayerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<PlayerEntity, Long> {

}