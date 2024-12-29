package com.javierdesant.spring_sport_flow.domain.entities;

import com.javierdesant.spring_sport_flow.utils.Role;
import com.javierdesant.spring_sport_flow.utils.RolePermission;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Inheritance(strategy = InheritanceType.JOINED)
@SuperBuilder(toBuilder = true)
public abstract class UserEntity implements UserDetails, Serializable {

    private static final String ROLE_PREFIX = "ROLE_";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(unique = true)
    private String email;

    private String password;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Role role = this.getRole();
        assert role != null;
        List<RolePermission> permissions = role.getPermissions();
        assert permissions != null;

        List<SimpleGrantedAuthority> authorities = new ArrayList<>(permissions.stream()
                .map(Enum::name)
                .map(SimpleGrantedAuthority::new)
                .toList());

        authorities.add(new SimpleGrantedAuthority(ROLE_PREFIX + role.name()));
        return authorities;
    }

    public abstract Role getRole();
}
