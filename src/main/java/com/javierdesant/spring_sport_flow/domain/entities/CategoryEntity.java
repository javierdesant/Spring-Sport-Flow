package com.javierdesant.spring_sport_flow.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;

@Entity(name = "categories")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CategoryEntity implements Serializable {

    @Id
    @Column(length = 50)
    private String categoryCode;

    @Column(length = 100, unique = true, nullable = false)
    private String categoryName;

    @OneToMany(mappedBy = "category")
    private Set<TournamentEntity> tournaments;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<StatisticEntity> statistics;
}
