package com.example.modbd.controllers;

import com.example.modbd.dtos.EmployeeDto;
import com.example.modbd.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping()
    public List<EmployeeDto> getAll() {

        return employeeService.getAll();

    }

    @GetMapping("/{id}")
    public EmployeeDto getById(@PathVariable Integer id) {

        return employeeService.getById(id);

    }

    @GetMapping("/getByType/{typeId}")
    public List<EmployeeDto> getByType(@PathVariable Integer typeId) {

        return employeeService.getByType(typeId);

    }

    @GetMapping("/getByRestaurant/{restaurantId}")
    public List<EmployeeDto> getByRestaurant(@PathVariable Integer restaurantId) {

        return employeeService.getByRestaurant(restaurantId);

    }

    @PostMapping()
    public void insert(@RequestBody EmployeeDto employeeDto) {

        employeeService.insert(employeeDto);

    }

    @PutMapping("/{id}")
    public void update(@PathVariable Integer id, @RequestParam String name, @RequestParam Integer salary, @RequestParam String hireDate, @RequestParam Integer typeId) {

        employeeService.udpate(id, name, salary, hireDate, typeId);

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {

        employeeService.deleteById(id);

    }

}
