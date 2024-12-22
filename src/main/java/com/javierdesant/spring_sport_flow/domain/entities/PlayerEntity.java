package com.javierdesant.spring_sport_flow.domain.entities;

import com.javierdesant.spring_sport_flow.utils.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@Entity(name = "players")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder(toBuilder = true)
public class PlayerEntity extends UserEntity {

    @Column(length = 100, nullable = false)
    private String firstName;

    @Column(length = 150, nullable = false)
    private String lastName;

    @Column(length = 15, unique = true, nullable = false)
    private String dni;

    @OneToMany(mappedBy = "player", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<StatisticEntity> statistics;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    private AdminEntity admin;

    @ManyToMany(mappedBy = "players")
    private Set<TeamEntity> teams;

    @Override
    protected Role getRole() {
        return Role.ADMIN;
    }

    @Override
    public String getUsername() {
        return this.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getFullName() {
        return this.getFirstName() + " " + this.getLastName();
    }
}
