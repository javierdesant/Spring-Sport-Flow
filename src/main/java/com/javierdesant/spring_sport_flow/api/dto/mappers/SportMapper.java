package com.javierdesant.spring_sport_flow.api.dto.mappers;

import com.javierdesant.spring_sport_flow.api.dto.responses.SportResponse;
import com.javierdesant.spring_sport_flow.domain.entities.SportEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SportMapper {
    SportResponse toSportResponse(SportEntity sportEntity);
}
