package com.example.modbd.services;

import com.example.modbd.dtos.OrderDrinkDto;
import com.example.modbd.entities.OrderDrink;
import com.example.modbd.mappers.OrderDrinkMapper;
import com.example.modbd.repository.OrderDrinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderDrinkService {

    @Autowired
    OrderDrinkRepository orderDrinkRepository;

    @Autowired
    OrderDrinkMapper orderDrinkMapper;

    public List<OrderDrinkDto> getAll() {

        List<OrderDrink> orderDrinks = orderDrinkRepository.findAll();
        List<OrderDrinkDto> orderDrinkDtos = new ArrayList<>();
        for (OrderDrink orderDrink : orderDrinks) {
            OrderDrinkDto orderDrinkDto = orderDrinkMapper.mapToDto(orderDrink);
            orderDrinkDtos.add(orderDrinkDto);
        }
        return orderDrinkDtos;

    }

    public OrderDrinkDto getById(Integer id) {

        Optional<OrderDrink> orderDrink = orderDrinkRepository.findById(id);
        OrderDrinkDto orderDrinkDto = orderDrinkMapper.mapToDto(orderDrink.get());
        return orderDrinkDto;

    }

    public List<OrderDrinkDto> getByOrder(Integer orderId) {

        List<OrderDrink> orderDrinks = orderDrinkRepository.findByOrder(orderId);
        List<OrderDrinkDto> orderDrinkDtos = new ArrayList<>();
        for (OrderDrink orderDrink : orderDrinks) {
            OrderDrinkDto orderDrinkDto = orderDrinkMapper.mapToDto(orderDrink);
            orderDrinkDtos.add(orderDrinkDto);
        }
        return orderDrinkDtos;

    }

    public List<OrderDrinkDto> getByDrink(Integer drinkId) {

        List<OrderDrink> orderDrinks = orderDrinkRepository.findByDrink(drinkId);
        List<OrderDrinkDto> orderDrinkDtos = new ArrayList<>();
        for (OrderDrink orderDrink : orderDrinks) {
            OrderDrinkDto orderDrinkDto = orderDrinkMapper.mapToDto(orderDrink);
            orderDrinkDtos.add(orderDrinkDto);
        }
        return orderDrinkDtos;

    }

    @Transactional
    public void insert(OrderDrinkDto orderDrinkDto) {

        System.out.println("orderDrinkDto.getCount() = " + orderDrinkDto.getCount());
        System.out.println("orderDrinkDto.getPrice() = " + orderDrinkDto.getPrice());
        System.out.println("orderDrinkDto.getOrderId() = " + orderDrinkDto.getOrderId());
        System.out.println("orderDrinkDto.getDrinkId() = " + orderDrinkDto.getDrinkId());
        OrderDrink orderDrink = orderDrinkMapper.mapToEntity(orderDrinkDto);
        System.out.println("orderDrink.getCount() = " + orderDrink.getCount());
        System.out.println("orderDrink.getPrice() = " + orderDrink.getPrice());
        System.out.println("orderDrink.getOrderId() = " + orderDrink.getOrderId());
        System.out.println("orderDrink.getDrinkId() = " + orderDrink.getDrinkId());
        orderDrinkRepository.insert(orderDrink.getCount(), orderDrink.getPrice(), orderDrink.getOrderId(), orderDrink.getDrinkId());

    }

    @Transactional
    public void udpate(Integer id, Integer count) {

        orderDrinkRepository.updateById(id, count);

    }

    @Transactional
    public void deleteById(Integer id) {

        orderDrinkRepository.deleteById(id);

    }

}
