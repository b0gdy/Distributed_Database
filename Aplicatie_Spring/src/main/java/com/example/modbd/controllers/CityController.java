package com.example.modbd.controllers;

import com.example.modbd.dtos.CityDto;
import com.example.modbd.entities.City;
import com.example.modbd.mappers.CityMapper;
import com.example.modbd.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cities")
public class CityController {

    @Autowired
    CityService cityService;

    @GetMapping()
    public List<CityDto> getAll() {

        return cityService.getAll();

    }

    @GetMapping("/{id}")
    public CityDto getById(@PathVariable Integer id) {

        return cityService.getById(id);

    }

    @PostMapping()
    public void insert(@RequestBody CityDto cityDto) {

        cityService.insert(cityDto);

    }

    @PutMapping("/{id}")
    public void update(@PathVariable Integer id, @RequestParam String name) {

        cityService.udpate(id, name);

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {

        cityService.deleteById(id);

    }

}
