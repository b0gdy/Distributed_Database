package com.example.modbd.controllers;

import com.example.modbd.dtos.DishDto;
import com.example.modbd.services.DishService;
import org.springframework.beans.factory.annotation.Autowired;;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dishes")
public class DishController {

    @Autowired
    DishService dishService;

    @GetMapping()
    public List<DishDto> getAll() {

        return dishService.getAll();

    }

    @GetMapping("/{id}")
    public DishDto getById(@PathVariable Integer id) {

        return dishService.getById(id);

    }

    @GetMapping("/getByMenu/{menuId}")
    public List<DishDto> getByMenu(@PathVariable Integer menuId) {

        return dishService.getByMenu(menuId);

    }

    @PostMapping()
    public void insert(@RequestBody DishDto dishDto) {

        dishService.insert(dishDto);

    }

    @PutMapping("/{id}")
    public void update(@PathVariable Integer id, @RequestParam String name, @RequestParam Integer price) {

        dishService.udpate(id, name, price);

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {

        dishService.deleteById(id);

    }

}
