package com.javierdesant.spring_sport_flow.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.Set;

@Entity
public class CategoryEntity extends BaseCodeEntity {

    @OneToMany(mappedBy = "category")
    private Set<TournamentEntity> tournaments;
}
