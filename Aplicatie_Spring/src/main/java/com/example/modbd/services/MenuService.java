package com.example.modbd.services;

import com.example.modbd.dtos.MenuDto;
import com.example.modbd.entities.Menu;
import com.example.modbd.mappers.MenuMapper;
import com.example.modbd.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MenuService {

    @Autowired
    MenuRepository menuRepository;

    @Autowired
    MenuMapper menuMapper;

    public List<MenuDto> getAll() {

        List<Menu> menus = menuRepository.findAll();
        List<MenuDto> menuDtos = new ArrayList<>();
        for (Menu menu : menus) {
            MenuDto menuDto = menuMapper.mapToDto(menu);
            menuDtos.add(menuDto);
        }
        return menuDtos;

    }

    public MenuDto getById(Integer id) {

        Optional<Menu> menu = menuRepository.findById(id);
        MenuDto menuDto = menuMapper.mapToDto(menu.get());
        return menuDto;

    }

    @Transactional
    public void insert(MenuDto menuDto) {

        Menu menu = menuMapper.mapToEntity(menuDto);
        menuRepository.insert(menu.getMenuDate());

    }

    @Transactional
    public void udpate(Integer id, String menuDate) {

        LocalDate menuDateEntity = LocalDate.parse(menuDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        menuRepository.updateById(id, menuDateEntity);

    }

    @Transactional
    public void deleteById(Integer id) {

        menuRepository.deleteById(id);

    }

}
