package com.example.modbd.mappers;

import com.example.modbd.dtos.MenuDto;
import com.example.modbd.entities.Menu;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MenuMapper {

    @Mapping(target = "id", source = "menu.id")
    @Mapping(target = "menuDate", source = "menu.menuDate", dateFormat = "yyyy-MM-dd")
    MenuDto mapToDto(Menu menu);

    @Mapping(target = "id", source = "menuDto.id")
    @Mapping(target = "menuDate", source = "menuDto.menuDate", dateFormat = "yyyy-MM-dd")
    Menu mapToEntity(MenuDto menuDto);

}
