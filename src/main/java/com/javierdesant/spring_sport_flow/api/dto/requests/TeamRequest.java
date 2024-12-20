package com.javierdesant.spring_sport_flow.api.dto.requests;

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
    private String teamName;
    private Set<Long> playerIds;
//    private Long adminId;
}
