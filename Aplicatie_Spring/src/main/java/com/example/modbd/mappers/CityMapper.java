package com.example.modbd.mappers;

import com.example.modbd.dtos.CityDto;
import com.example.modbd.entities.City;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CityMapper {

    @Mapping(target = "id", source = "city.id")
    @Mapping(target = "name", source = "city.name")
    @Mapping(target = "region", source = "city.region")
    CityDto mapToDto(City city);

    @Mapping(target = "id", source = "cityDto.id")
    @Mapping(target = "name", source = "cityDto.name")
    @Mapping(target = "region", source = "cityDto.region")
    City mapToEntity(CityDto cityDto);

}
