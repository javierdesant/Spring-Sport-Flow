package com.javierdesant.spring_sport_flow.api.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
public abstract class BaseCodeResponse implements Serializable {
    private String code;
    private String name;
}