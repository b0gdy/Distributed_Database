package com.example.modbd.controllers;

import com.example.modbd.dtos.OrderDto;
import com.example.modbd.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping()
    public List<OrderDto> getAll() {

        return orderService.getAll();

    }

    @GetMapping("/{id}")
    public OrderDto getById(@PathVariable Integer id) {

        return orderService.getById(id);

    }

    @GetMapping("/getByWaiter/{waiterId}")
    public List<OrderDto> getByWaiter(@PathVariable Integer waiterId) {

        return orderService.getByWaiter(waiterId);

    }

    @PostMapping()
    public void insert(@RequestBody OrderDto orderDto) {

        orderService.insert(orderDto);

    }

    @PutMapping("/{id}")
    public void update(@PathVariable Integer id, @RequestParam Integer tip) {

        orderService.udpate(id, tip);

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {

        orderService.deleteById(id);

    }

}
