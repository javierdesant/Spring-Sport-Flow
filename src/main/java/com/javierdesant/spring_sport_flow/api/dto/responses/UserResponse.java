package com.javierdesant.spring_sport_flow.api.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class UserResponse implements Serializable {
    private Long id;
    private String email;
}
