package com.javierdesant.spring_sport_flow.domain.repositories;

import com.javierdesant.spring_sport_flow.domain.entities.SportEntity;
import org.springframework.data.repository.CrudRepository;

public interface SportRepository extends CrudRepository<SportEntity, String> {
}
