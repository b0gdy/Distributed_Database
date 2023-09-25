package com.example.modbd.controllers;

import com.example.modbd.dtos.RestaurantDto;
import com.example.modbd.mappers.RestaurantMapper;
import com.example.modbd.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    @Autowired
    RestaurantService restaurantService;

    @GetMapping()
    public List<RestaurantDto> getAll() {

        return restaurantService.getAll();

    }

    @GetMapping("/{id}")
    public RestaurantDto getById(@PathVariable Integer id) {

        return restaurantService.getById(id);

    }

    @GetMapping("/getByCity/{cityId}")
    public List<RestaurantDto> getByCity(@PathVariable Integer cityId) {

        return restaurantService.getByCity(cityId);

    }

    @PostMapping()
    public void insert(@RequestBody RestaurantDto restaurantDto) {

        restaurantService.insert(restaurantDto);

    }

    @PutMapping("/{id}")
    public void update(@PathVariable Integer id, @RequestParam String name) {

        restaurantService.udpate(id, name);

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {

        restaurantService.deleteById(id);

    }

}
