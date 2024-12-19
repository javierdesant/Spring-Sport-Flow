package com.javierdesant.spring_sport_flow.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.Set;

@Entity
public class SportEntity extends BaseCodeEntity {

    @OneToMany(mappedBy = "sport")
    private Set<TournamentEntity> tournaments;

}
