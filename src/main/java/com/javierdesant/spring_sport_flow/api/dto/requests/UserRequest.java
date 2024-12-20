package com.javierdesant.spring_sport_flow.api.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class UserRequest implements Serializable {
    private String email;
    private String password;
}
