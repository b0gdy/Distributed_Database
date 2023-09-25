package com.example.modbd.services;

import com.example.modbd.dtos.DrinkDto;
import com.example.modbd.entities.Drink;
import com.example.modbd.mappers.DrinkMapper;
import com.example.modbd.repository.DrinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DrinkService {

    @Autowired
    DrinkRepository drinkRepository;

    @Autowired
    DrinkMapper drinkMapper;

    public List<DrinkDto> getAll() {

        List<Drink> drinks = drinkRepository.findAll();
        List<DrinkDto> drinkDtos = new ArrayList<>();
        for (Drink drink : drinks) {
            DrinkDto drinkDto = drinkMapper.mapToDto(drink);
            drinkDtos.add(drinkDto);
        }
        return drinkDtos;

    }

    public DrinkDto getById(Integer id) {

        Optional<Drink> drink = drinkRepository.findById(id);
        DrinkDto drinkDto = drinkMapper.mapToDto(drink.get());
        return drinkDto;

    }

    public List<DrinkDto> getByMenu(Integer menuId) {

        List<Drink> drinks = drinkRepository.findByMenu(menuId);
        List<DrinkDto> drinkDtos = new ArrayList<>();
        for (Drink drink : drinks) {
            DrinkDto drinkDto = drinkMapper.mapToDto(drink);
            drinkDtos.add(drinkDto);
        }
        return drinkDtos;

    }

    @Transactional
    public void insert(DrinkDto drinkDto) {

        Drink drink = drinkMapper.mapToEntity(drinkDto);
        drinkRepository.insert(drink.getName(), drink.getPrice(), drink.getMenuId(), drink.getType());

    }

    @Transactional
    public void udpate(Integer id, String name, Integer price, String type) {

        drinkRepository.updateById(id, name, price, type);

    }

    @Transactional
    public void deleteById(Integer id) {

        drinkRepository.deleteById(id);

    }

}
