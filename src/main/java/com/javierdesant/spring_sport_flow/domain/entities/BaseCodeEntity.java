package com.javierdesant.spring_sport_flow.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

import java.io.Serializable;

@Data
@MappedSuperclass
public abstract class BaseCodeEntity implements Serializable {

    @Id
    @Column(length = 50)
    private String code;

    @Column(length = 100, unique = true, nullable = false)
    private String name;
}
