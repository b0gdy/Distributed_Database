package com.example.modbd.mappers;

import com.example.modbd.dtos.RestaurantDto;
import com.example.modbd.entities.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RestaurantMapper {

    @Mapping(target = "id", source = "restaurant.id")
    @Mapping(target = "name", source = "restaurant.name")
    @Mapping(target = "cityId", source = "restaurant.cityId")
    RestaurantDto mapToDto(Restaurant restaurant);

    @Mapping(target = "id", source = "restaurantDto.id")
    @Mapping(target = "name", source = "restaurantDto.name")
    @Mapping(target = "cityId", source = "restaurantDto.cityId")
    Restaurant mapToEntity(RestaurantDto restaurantDto);
    
}
