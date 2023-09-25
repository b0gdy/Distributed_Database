package com.example.modbd.mappers;

import com.example.modbd.dtos.OrderDto;
import com.example.modbd.entities.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    @Mapping(target = "id", source = "order.id")
    @Mapping(target = "orderDate", source = "order.orderDate", dateFormat = "yyyy-MM-dd HH:mm")
    @Mapping(target = "total", source = "order.total")
    @Mapping(target = "tip", source = "order.tip")
    @Mapping(target = "waiterId", source = "order.waiterId")
    OrderDto mapToDto(Order order);

    @Mapping(target = "id", source = "orderDto.id")
    @Mapping(target = "orderDate", source = "orderDto.orderDate", dateFormat = "yyyy-MM-dd HH:mm")
    @Mapping(target = "total", source = "orderDto.total")
    @Mapping(target = "tip", source = "orderDto.tip")
    @Mapping(target = "waiterId", source = "orderDto.waiterId")
    Order mapToEntity(OrderDto orderDto);

}
