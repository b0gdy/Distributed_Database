package com.example.modbd.mappers;

import com.example.modbd.dtos.DishDto;
import com.example.modbd.entities.Dish;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DishMapper {

    @Mapping(target = "id", source = "dish.id")
    @Mapping(target = "name", source = "dish.name")
    @Mapping(target = "price", source = "dish.price")
    @Mapping(target = "menuId", source = "dish.menuId")
    DishDto mapToDto(Dish dish);

    @Mapping(target = "id", source = "dishDto.id")
    @Mapping(target = "name", source = "dishDto.name")
    @Mapping(target = "price", source = "dishDto.price")
    @Mapping(target = "menuId", source = "dishDto.menuId")
    Dish mapToEntity(DishDto dishDto);

}
