package com.example.modbd.controllers;

import com.example.modbd.dtos.MenuDto;
import com.example.modbd.services.MenuService;
import org.springframework.beans.factory.annotation.Autowired;;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menus")
public class MenuController {

    @Autowired
    MenuService menuService;

    @GetMapping()
    public List<MenuDto> getAll() {

        return menuService.getAll();

    }

    @GetMapping("/{id}")
    public MenuDto getById(@PathVariable Integer id) {

        return menuService.getById(id);

    }

    @PostMapping()
    public void insert(@RequestBody MenuDto menuDto) {

        menuService.insert(menuDto);

    }

    @PutMapping("/{id}")
    public void update(@PathVariable Integer id, @RequestParam String menuDate) {

        menuService.udpate(id, menuDate);

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {

        menuService.deleteById(id);

    }

}
