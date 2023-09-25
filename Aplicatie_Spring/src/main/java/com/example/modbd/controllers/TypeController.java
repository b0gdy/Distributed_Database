package com.example.modbd.controllers;

import com.example.modbd.dtos.TypeDto;
import com.example.modbd.entities.Type;
import com.example.modbd.mappers.TypeMapper;
import com.example.modbd.services.TypeService;
import org.springframework.beans.factory.annotation.Autowired;;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/types")
public class TypeController {

    @Autowired
    TypeService typeService;

    @GetMapping()
    public List<TypeDto> getAll() {

        return typeService.getAll();

    }

    @GetMapping("/{id}")
    public TypeDto getById(@PathVariable Integer id) {

        return typeService.getById(id);

    }

    @PostMapping()
    public void insert(@RequestBody TypeDto typeDto) {

        typeService.insert(typeDto);

    }

    @PutMapping("/{id}")
    public void update(@PathVariable Integer id, @RequestParam String name, @RequestParam Integer minSalary, @RequestParam Integer maxSalary) {

        typeService.udpate(id, name, minSalary, maxSalary);

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {

        typeService.deleteById(id);

    }

}
