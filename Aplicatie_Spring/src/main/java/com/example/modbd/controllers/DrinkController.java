package com.example.modbd.controllers;

import com.example.modbd.dtos.DrinkDto;
import com.example.modbd.services.DrinkService;
import org.springframework.beans.factory.annotation.Autowired;;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/drinks")
public class DrinkController {

    @Autowired
    DrinkService drinkService;

    @GetMapping()
    public List<DrinkDto> getAll() {

        return drinkService.getAll();

    }

    @GetMapping("/{id}")
    public DrinkDto getById(@PathVariable Integer id) {

        return drinkService.getById(id);

    }

    @GetMapping("/getByMenu/{menuId}")
    public List<DrinkDto> getByMenu(@PathVariable Integer menuId) {

        return drinkService.getByMenu(menuId);

    }

    @PostMapping()
    public void insert(@RequestBody DrinkDto drinkDto) {

        drinkService.insert(drinkDto);

    }

    @PutMapping("/{id}")
    public void update(@PathVariable Integer id, @RequestParam String name, @RequestParam Integer price, @RequestParam String type) {

        drinkService.udpate(id, name, price, type);

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {

        drinkService.deleteById(id);

    }

}
