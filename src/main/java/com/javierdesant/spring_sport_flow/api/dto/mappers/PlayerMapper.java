package com.javierdesant.spring_sport_flow.api.dto.mappers;

import com.javierdesant.spring_sport_flow.api.dto.responses.PlayerResponse;
import com.javierdesant.spring_sport_flow.domain.entities.PlayerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PlayerMapper {     // TODO: is adminResponse missing ?
    @Mapping(target = "userId")
    @Mapping(target = "email")
    @Mapping(target = "firstName")
    @Mapping(target = "lastName")
    @Mapping(target = "dni")
    PlayerResponse toPlayerResponse(PlayerEntity playerEntity);
}
