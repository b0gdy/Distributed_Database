package com.example.modbd.mappers;

import com.example.modbd.dtos.OrderDrinkDto;
import com.example.modbd.entities.OrderDrink;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderDrinkMapper {

    @Mapping(target = "id", source = "orderDrink.id")
    @Mapping(target = "count", source = "orderDrink.count")
    @Mapping(target = "price", source = "orderDrink.price")
    @Mapping(target = "orderId", source = "orderDrink.orderId")
    @Mapping(target = "drinkId", source = "orderDrink.drinkId")
    OrderDrinkDto mapToDto(OrderDrink orderDrink);
    
    @Mapping(target = "id", source = "orderDrinkDto.id")
    @Mapping(target = "count", source = "orderDrinkDto.count")
    @Mapping(target = "price", source = "orderDrinkDto.price")
    @Mapping(target = "orderId", source = "orderDrinkDto.orderId")
    @Mapping(target = "drinkId", source = "orderDrinkDto.drinkId")
    OrderDrink mapToEntity(OrderDrinkDto orderDrinkDto);

}
