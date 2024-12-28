package com.javierdesant.spring_sport_flow.api.dto.mappers;

import com.javierdesant.spring_sport_flow.api.dto.responses.LeagueResponse;
import com.javierdesant.spring_sport_flow.domain.entities.LeagueEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LeagueMapper {
    LeagueResponse toLeagueResponse(LeagueEntity leagueEntity);
}
