package com.javierdesant.spring_sport_flow.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity(name = "categories")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
@MappedSuperclass
public class CategoryEntity extends BaseCodeEntity {

    @OneToMany(mappedBy = "category")
    private Set<TournamentEntity> tournaments;
}
