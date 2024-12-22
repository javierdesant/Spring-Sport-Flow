package com.javierdesant.spring_sport_flow.api.dto.mappers;

import com.javierdesant.spring_sport_flow.api.dto.responses.TournamentResponse;
import com.javierdesant.spring_sport_flow.domain.entities.TournamentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {LeagueMapper.class, SportMapper.class, CategoryMapper.class})
public interface TournamentMapper {
    @Mapping(target = "tournamentId")
    @Mapping(target = "tournamentName")
    @Mapping(target = "startDate")
    @Mapping(target = "endDate")
    @Mapping(target = "league")
    @Mapping(target = "sport")
    @Mapping(target = "category")
    TournamentResponse toResponse(TournamentEntity entity);
}