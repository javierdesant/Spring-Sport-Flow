package com.javierdesant.spring_sport_flow.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity(name = "administrators")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AdminEntity extends UserEntity {

    @OneToMany(mappedBy = "admin")
    private Set<TeamEntity> managedTeams;

}