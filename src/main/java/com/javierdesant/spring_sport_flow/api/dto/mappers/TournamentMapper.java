package com.javierdesant.spring_sport_flow.api.dto.mappers;

import com.javierdesant.spring_sport_flow.api.dto.responses.CategoryResponse;
import com.javierdesant.spring_sport_flow.api.dto.responses.LeagueResponse;
import com.javierdesant.spring_sport_flow.api.dto.responses.SportResponse;
import com.javierdesant.spring_sport_flow.api.dto.responses.TournamentResponse;
import com.javierdesant.spring_sport_flow.domain.entities.CategoryEntity;
import com.javierdesant.spring_sport_flow.domain.entities.LeagueEntity;
import com.javierdesant.spring_sport_flow.domain.entities.SportEntity;
import com.javierdesant.spring_sport_flow.domain.entities.TournamentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TournamentMapper {

    TournamentMapper INSTANCE = Mappers.getMapper(TournamentMapper.class);

    @Mapping(target = "category", source = "category")
    @Mapping(target = "sport", source = "sport")
    @Mapping(target = "league", source = "league")
    TournamentResponse toResponse(TournamentEntity entity);

    CategoryResponse toCategoryResponse(CategoryEntity category);

    SportResponse toSportResponse(SportEntity sport);

    LeagueResponse toLeagueResponse(LeagueEntity league);
}