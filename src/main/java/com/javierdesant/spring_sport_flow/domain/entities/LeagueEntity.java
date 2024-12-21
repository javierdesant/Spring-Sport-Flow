package com.javierdesant.spring_sport_flow.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;

@Entity(name = "leagues")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class LeagueEntity implements Serializable {

    @Id
    @Column(length = 50)
    private String leagueCode;

    @Column(length = 100, unique = true, nullable = false)
    private String leagueName;

    @OneToMany(mappedBy = "league")
    private Set<TournamentEntity> tournaments;

}
