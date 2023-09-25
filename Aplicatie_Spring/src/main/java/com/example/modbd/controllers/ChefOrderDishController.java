package com.example.modbd.controllers;

import com.example.modbd.dtos.ChefOrderDishDto;
import com.example.modbd.services.ChefOrderDishService;
import org.springframework.beans.factory.annotation.Autowired;;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chefOrderDishes")
public class ChefOrderDishController {

    @Autowired
    ChefOrderDishService chefOrderDishService;

    @GetMapping()
    public List<ChefOrderDishDto> getAll() {

        return chefOrderDishService.getAll();

    }

    @GetMapping("/{id}")
    public ChefOrderDishDto getById(@PathVariable Integer id) {

        return chefOrderDishService.getById(id);

    }

    @GetMapping("/getByChef/{chefId}")
    public List<ChefOrderDishDto> getByChef(@PathVariable Integer chefId) {

        return chefOrderDishService.getByChef(chefId);

    }

    @GetMapping("/getByOrder/{orderId}")
    public List<ChefOrderDishDto> getByOrder(@PathVariable Integer orderId) {

        return chefOrderDishService.getByOrder(orderId);

    }

    @GetMapping("/getByDish/{dishId}")
    public List<ChefOrderDishDto> getByDish(@PathVariable Integer dishId) {

        return chefOrderDishService.getByDish(dishId);

    }

    @PostMapping()
    public void insert(@RequestBody ChefOrderDishDto chefOrderDishDto) {

        chefOrderDishService.insert(chefOrderDishDto);

    }

    @PutMapping("/{id}")
    public void update(@PathVariable Integer id, @RequestParam Integer count) {

        chefOrderDishService.udpate(id, count);

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {

        chefOrderDishService.deleteById(id);

    }

}
