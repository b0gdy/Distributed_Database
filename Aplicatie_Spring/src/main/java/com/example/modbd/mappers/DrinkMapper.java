package com.example.modbd.mappers;

import com.example.modbd.dtos.DrinkDto;
import com.example.modbd.entities.Drink;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DrinkMapper {

    @Mapping(target = "id", source = "drink.id")
    @Mapping(target = "name", source = "drink.name")
    @Mapping(target = "type", source = "drink.type")
    @Mapping(target = "price", source = "drink.price")
    @Mapping(target = "menuId", source = "drink.menuId")
    DrinkDto mapToDto(Drink drink);

    @Mapping(target = "id", source = "drinkDto.id")
    @Mapping(target = "name", source = "drinkDto.name")
    @Mapping(target = "type", source = "drinkDto.type")
    @Mapping(target = "price", source = "drinkDto.price")
    @Mapping(target = "menuId", source = "drinkDto.menuId")
    Drink mapToEntity(DrinkDto drinkDto);

}
