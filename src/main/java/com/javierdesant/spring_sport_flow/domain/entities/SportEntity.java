package com.javierdesant.spring_sport_flow.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;

@Entity(name = "sports")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SportEntity implements Serializable {

    @Id
    @Column(length = 50)
    private String sportCode;

    @Column(length = 100, unique = true, nullable = false)
    private String sportName;

    @OneToMany(mappedBy = "sport")
    private Set<TournamentEntity> tournaments;

}
