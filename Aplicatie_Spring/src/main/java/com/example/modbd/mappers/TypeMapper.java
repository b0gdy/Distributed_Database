package com.example.modbd.mappers;

import com.example.modbd.dtos.TypeDto;
import com.example.modbd.entities.Type;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TypeMapper {

    @Mapping(target = "id", source = "type.id")
    @Mapping(target = "name", source = "type.name")
    @Mapping(target = "minSalary", source = "type.minSalary")
    @Mapping(target = "maxSalary", source = "type.maxSalary")
    TypeDto mapToDto(Type type);

    @Mapping(target = "id", source = "typeDto.id")
    @Mapping(target = "name", source = "typeDto.name")
    @Mapping(target = "minSalary", source = "typeDto.minSalary")
    @Mapping(target = "maxSalary", source = "typeDto.maxSalary")
    Type mapToEntity(TypeDto typeDto);
    
}
