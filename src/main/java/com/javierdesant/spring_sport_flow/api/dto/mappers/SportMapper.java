package com.javierdesant.spring_sport_flow.api.dto.mappers;

import com.javierdesant.spring_sport_flow.api.dto.responses.SportResponse;
import com.javierdesant.spring_sport_flow.domain.entities.SportEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SportMapper {
    @Mapping(target = "sportCode")
    @Mapping(target = "sportName")
    SportResponse toSportResponse(SportEntity sportEntity);
}
