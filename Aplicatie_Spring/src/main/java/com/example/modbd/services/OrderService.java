package com.example.modbd.services;

import com.example.modbd.dtos.OrderDto;
import com.example.modbd.entities.Order;
import com.example.modbd.mappers.OrderMapper;
import com.example.modbd.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderMapper orderMapper;

    public List<OrderDto> getAll() {

        List<Order> orders = orderRepository.findAll();
        List<OrderDto> orderDtos = new ArrayList<>();
        for (Order order : orders) {
            OrderDto orderDto = orderMapper.mapToDto(order);
            orderDtos.add(orderDto);
        }
        return orderDtos;

    }

    public OrderDto getById(Integer id) {

        Optional<Order> order = orderRepository.findById(id);
        OrderDto orderDto = orderMapper.mapToDto(order.get());
        return orderDto;

    }

    public List<OrderDto> getByWaiter(Integer waiterId) {

        List<Order> orders = orderRepository.findByWaiter(waiterId);
        List<OrderDto> orderDtos = new ArrayList<>();
        for (Order order : orders) {
            OrderDto orderDto = orderMapper.mapToDto(order);
            orderDtos.add(orderDto);
        }
        return orderDtos;

    }

    @Transactional
    public void insert(OrderDto orderDto) {

        Order order = orderMapper.mapToEntity(orderDto);
        orderRepository.insert(order.getOrderDate(), order.getTotal(), order.getTip(), order.getWaiterId());

    }

    @Transactional
    public void udpate(Integer id, Integer tip) {

        orderRepository.updateById(id, tip);

    }

    @Transactional
    public void deleteById(Integer id) {

        orderRepository.deleteById(id);

    }

}
