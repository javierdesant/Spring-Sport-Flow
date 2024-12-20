package com.javierdesant.spring_sport_flow.domain.repositories;

import com.javierdesant.spring_sport_flow.domain.entities.LeagueEntity;
import org.springframework.data.repository.CrudRepository;

public interface LeagueRepository extends CrudRepository<LeagueEntity, String> {
}
