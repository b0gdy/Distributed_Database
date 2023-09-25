package com.example.modbd.services;

import com.example.modbd.dtos.EmployeeDto;
import com.example.modbd.entities.Employee;
import com.example.modbd.mappers.EmployeeMapper;
import com.example.modbd.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    EmployeeMapper employeeMapper;

    public List<EmployeeDto> getAll() {

        List<Employee> employees = employeeRepository.findAll();
        List<EmployeeDto> employeeDtos = new ArrayList<>();
        for (Employee employee : employees) {
            EmployeeDto employeeDto = employeeMapper.mapToDto(employee);
            employeeDtos.add(employeeDto);
        }
        return employeeDtos;

    }

    public EmployeeDto getById(Integer id) {

        Optional<Employee> employee = employeeRepository.findById(id);
        EmployeeDto employeeDto = employeeMapper.mapToDto(employee.get());
        return employeeDto;

    }

    public List<EmployeeDto> getByType(Integer typeId) {

        List<Employee> employees = employeeRepository.findByType(typeId);
        List<EmployeeDto> employeeDtos = new ArrayList<>();
        for (Employee employee : employees) {
            EmployeeDto employeeDto = employeeMapper.mapToDto(employee);
            employeeDtos.add(employeeDto);
        }
        return employeeDtos;

    }

    public List<EmployeeDto> getByRestaurant(Integer restaurantId) {

        List<Employee> employees = employeeRepository.findByRestaurant(restaurantId);
        List<EmployeeDto> employeeDtos = new ArrayList<>();
        for (Employee employee : employees) {
            EmployeeDto employeeDto = employeeMapper.mapToDto(employee);
            employeeDtos.add(employeeDto);
        }
        return employeeDtos;

    }

    @Transactional
    public void insert(EmployeeDto employeeDto) {

        Employee employee = employeeMapper.mapToEntity(employeeDto);
        employeeRepository.insert(employee.getName(), employee.getSalary(), employee.getHireDate(), employee.getTypeId(), employee.getRestaurantId());

    }

    @Transactional
    public void udpate(Integer id, String name, Integer salary, String hireDate, Integer typeId) {

        LocalDate hireDateEntity = LocalDate.parse(hireDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        employeeRepository.updateById(id, name, salary, hireDateEntity, typeId);

    }

    @Transactional
    public void deleteById(Integer id) {

        employeeRepository.deleteById(id);

    }

}
