package com.javierdesant.spring_sport_flow.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@Data
@MappedSuperclass
public abstract class BaseCodeEntity {

    @Id
    @Column(length = 50)
    private String code;

    @Column(length = 100, unique = true, nullable = false)
    private String name;
}
