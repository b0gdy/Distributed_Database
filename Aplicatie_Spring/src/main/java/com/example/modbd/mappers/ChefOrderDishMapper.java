package com.example.modbd.mappers;

import com.example.modbd.dtos.ChefOrderDishDto;
import com.example.modbd.entities.ChefOrderDish;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ChefOrderDishMapper {

    @Mapping(target = "id", source = "chefOrderDish.id")
    @Mapping(target = "count", source = "chefOrderDish.count")
    @Mapping(target = "price", source = "chefOrderDish.price")
    @Mapping(target = "chefId", source = "chefOrderDish.chefId")
    @Mapping(target = "orderId", source = "chefOrderDish.orderId")
    @Mapping(target = "dishId", source = "chefOrderDish.dishId")
    ChefOrderDishDto mapToDto(ChefOrderDish chefOrderDish);

    @Mapping(target = "id", source = "chefOrderDishDto.id")
    @Mapping(target = "count", source = "chefOrderDishDto.count")
    @Mapping(target = "price", source = "chefOrderDishDto.price")
    @Mapping(target = "chefId", source = "chefOrderDishDto.chefId")
    @Mapping(target = "orderId", source = "chefOrderDishDto.orderId")
    @Mapping(target = "dishId", source = "chefOrderDishDto.dishId")
    ChefOrderDish mapToEntity(ChefOrderDishDto chefOrderDishDto);

}
