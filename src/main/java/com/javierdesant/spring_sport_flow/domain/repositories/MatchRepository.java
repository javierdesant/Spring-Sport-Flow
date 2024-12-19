package com.javierdesant.spring_sport_flow.domain.repositories;

import com.javierdesant.spring_sport_flow.domain.entities.MatchEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchRepository extends JpaRepository<MatchEntity, Long> {
}
