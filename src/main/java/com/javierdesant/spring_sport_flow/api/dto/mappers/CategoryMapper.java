package com.javierdesant.spring_sport_flow.api.dto.mappers;

import com.javierdesant.spring_sport_flow.api.dto.responses.CategoryResponse;
import com.javierdesant.spring_sport_flow.domain.entities.CategoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Mapping(target = "categoryCode")
    @Mapping(target = "categoryName")
    CategoryResponse toCategoryResponse(CategoryEntity categoryEntity);
}
