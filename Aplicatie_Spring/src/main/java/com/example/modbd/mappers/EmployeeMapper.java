package com.example.modbd.mappers;

import com.example.modbd.dtos.EmployeeDto;
import com.example.modbd.entities.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    @Mapping(target = "id", source = "employee.id")
    @Mapping(target = "name", source = "employee.name")
    @Mapping(target = "salary", source = "employee.salary")
    @Mapping(target = "hireDate", source = "employee.hireDate", dateFormat = "yyyy-MM-dd")
    @Mapping(target = "typeId", source = "employee.typeId")
    @Mapping(target = "restaurantId", source = "employee.restaurantId")
    EmployeeDto mapToDto(Employee employee);

    @Mapping(target = "id", source = "employeeDto.id")
    @Mapping(target = "name", source = "employeeDto.name")
    @Mapping(target = "salary", source = "employeeDto.salary")
    @Mapping(target = "hireDate", source = "employeeDto.hireDate", dateFormat = "yyyy-MM-dd")
    @Mapping(target = "typeId", source = "employeeDto.typeId")
    @Mapping(target = "restaurantId", source = "employeeDto.restaurantId")
    Employee mapToEntity(EmployeeDto employeeDto);

}
