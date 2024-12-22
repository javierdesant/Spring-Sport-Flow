package com.javierdesant.spring_sport_flow.api.dto.mappers;

import com.javierdesant.spring_sport_flow.api.dto.responses.LeagueResponse;
import com.javierdesant.spring_sport_flow.domain.entities.LeagueEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LeagueMapper {
    @Mapping(target = "leagueCode")
    @Mapping(target = "leagueName")
    LeagueResponse toLeagueResponse(LeagueEntity leagueEntity);
}
