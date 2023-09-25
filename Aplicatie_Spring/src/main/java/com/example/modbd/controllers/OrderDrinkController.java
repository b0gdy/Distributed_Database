package com.example.modbd.controllers;

import com.example.modbd.dtos.OrderDrinkDto;
import com.example.modbd.services.OrderDrinkService;
import org.springframework.beans.factory.annotation.Autowired;;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orderDrinks")
public class OrderDrinkController {

    @Autowired
    OrderDrinkService orderDrinkService;

    @GetMapping()
    public List<OrderDrinkDto> getAll() {

        return orderDrinkService.getAll();

    }

    @GetMapping("/{id}")
    public OrderDrinkDto getById(@PathVariable Integer id) {

        return orderDrinkService.getById(id);

    }

    @GetMapping("/getByOrder/{orderId}")
    public List<OrderDrinkDto> getByOrder(@PathVariable Integer orderId) {

        return orderDrinkService.getByOrder(orderId);

    }

    @GetMapping("/getByDrink/{drinkId}")
    public List<OrderDrinkDto> getByDrink(@PathVariable Integer drinkId) {

        return orderDrinkService.getByDrink(drinkId);

    }

    @PostMapping()
    public void insert(@RequestBody OrderDrinkDto orderDrinkDto) {

        orderDrinkService.insert(orderDrinkDto);

    }

    @PutMapping("/{id}")
    public void update(@PathVariable Integer id, @RequestParam Integer count) {

        orderDrinkService.udpate(id, count);

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {

        orderDrinkService.deleteById(id);

    }

}
