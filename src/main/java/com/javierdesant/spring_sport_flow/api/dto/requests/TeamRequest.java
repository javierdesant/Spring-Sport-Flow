package com.javierdesant.spring_sport_flow.api.dto.requests;

import com.javierdesant.spring_sport_flow.utils.validation.AtLeastTwo;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class TeamRequest implements Serializable {

    @NotBlank
    private String teamName;

    @AtLeastTwo
    private Set<Long> playerIds;

}
