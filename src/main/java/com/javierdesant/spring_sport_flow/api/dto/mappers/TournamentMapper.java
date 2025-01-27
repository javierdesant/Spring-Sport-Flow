package com.javierdesant.spring_sport_flow.api.dto.mappers;

import com.javierdesant.spring_sport_flow.api.dto.responses.TournamentResponse;
import com.javierdesant.spring_sport_flow.domain.entities.TournamentEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TournamentMapper {
    TournamentResponse toTournamentResponse(TournamentEntity entity);
}