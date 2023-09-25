package com.example.modbd.services;

import com.example.modbd.dtos.DishDto;
import com.example.modbd.entities.Dish;
import com.example.modbd.mappers.DishMapper;
import com.example.modbd.repository.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DishService {

    @Autowired
    DishRepository dishRepository;

    @Autowired
    DishMapper dishMapper;

    public List<DishDto> getAll() {

        List<Dish> dishes = dishRepository.findAll();
        List<DishDto> dishDtos = new ArrayList<>();
        for (Dish dish : dishes) {
            DishDto dishDto = dishMapper.mapToDto(dish);
            dishDtos.add(dishDto);
        }
        return dishDtos;

    }

    public DishDto getById(Integer id) {

        Optional<Dish> dish = dishRepository.findById(id);
        DishDto dishDto = dishMapper.mapToDto(dish.get());
        return dishDto;

    }

    public List<DishDto> getByMenu(Integer menuId) {

        List<Dish> dishes = dishRepository.findByMenu(menuId);
        List<DishDto> dishDtos = new ArrayList<>();
        for (Dish dish : dishes) {
            DishDto dishDto = dishMapper.mapToDto(dish);
            dishDtos.add(dishDto);
        }
        return dishDtos;

    }

    @Transactional
    public void insert(DishDto dishDto) {

        Dish dish = dishMapper.mapToEntity(dishDto);
        dishRepository.insert(dish.getName(), dish.getPrice(), dish.getMenuId());

    }

    @Transactional
    public void udpate(Integer id, String name, Integer price) {

        dishRepository.updateById(id, name, price);

    }

    @Transactional
    public void deleteById(Integer id) {

        dishRepository.deleteById(id);

    }

}
