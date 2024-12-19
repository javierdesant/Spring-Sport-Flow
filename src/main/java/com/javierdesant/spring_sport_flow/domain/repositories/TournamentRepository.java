package com.javierdesant.spring_sport_flow.domain.repositories;

import com.javierdesant.spring_sport_flow.domain.entities.TournamentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TournamentRepository extends JpaRepository<TournamentEntity, Long> {
}
