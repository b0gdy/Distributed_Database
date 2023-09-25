package com.example.modbd.services;

import com.example.modbd.dtos.ChefOrderDishDto;
import com.example.modbd.entities.ChefOrderDish;
import com.example.modbd.mappers.ChefOrderDishMapper;
import com.example.modbd.repository.ChefOrderDishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ChefOrderDishService {

    @Autowired
    ChefOrderDishRepository chefOrderDishRepository;

    @Autowired
    ChefOrderDishMapper chefOrderDishMapper;

    public List<ChefOrderDishDto> getAll() {

        List<ChefOrderDish> chefOrderDishes = chefOrderDishRepository.findAll();
        List<ChefOrderDishDto> chefOrderDishDtos = new ArrayList<>();
        for (ChefOrderDish chefOrderDish : chefOrderDishes) {
            ChefOrderDishDto chefOrderDishDto = chefOrderDishMapper.mapToDto(chefOrderDish);
            chefOrderDishDtos.add(chefOrderDishDto);
        }
        return chefOrderDishDtos;

    }

    public ChefOrderDishDto getById(Integer id) {

        Optional<ChefOrderDish> chefOrderDish = chefOrderDishRepository.findById(id);
        ChefOrderDishDto chefOrderDishDto = chefOrderDishMapper.mapToDto(chefOrderDish.get());
        return chefOrderDishDto;

    }

    public List<ChefOrderDishDto> getByChef(Integer chefId) {

        List<ChefOrderDish> chefOrderDishes = chefOrderDishRepository.findByChef(chefId);
        List<ChefOrderDishDto> chefOrderDishDtos = new ArrayList<>();
        for (ChefOrderDish chefOrderDish : chefOrderDishes) {
            ChefOrderDishDto chefOrderDishDto = chefOrderDishMapper.mapToDto(chefOrderDish);
            chefOrderDishDtos.add(chefOrderDishDto);
        }
        return chefOrderDishDtos;

    }

    public List<ChefOrderDishDto> getByOrder(Integer orderId) {

        List<ChefOrderDish> chefOrderDishes = chefOrderDishRepository.findByOrder(orderId);
        List<ChefOrderDishDto> chefOrderDishDtos = new ArrayList<>();
        for (ChefOrderDish chefOrderDish : chefOrderDishes) {
            ChefOrderDishDto chefOrderDishDto = chefOrderDishMapper.mapToDto(chefOrderDish);
            chefOrderDishDtos.add(chefOrderDishDto);
        }
        return chefOrderDishDtos;

    }

    public List<ChefOrderDishDto> getByDish(Integer dishId) {

        List<ChefOrderDish> chefOrderDishes = chefOrderDishRepository.findByDish(dishId);
        List<ChefOrderDishDto> chefOrderDishDtos = new ArrayList<>();
        for (ChefOrderDish chefOrderDish : chefOrderDishes) {
            ChefOrderDishDto chefOrderDishDto = chefOrderDishMapper.mapToDto(chefOrderDish);
            chefOrderDishDtos.add(chefOrderDishDto);
        }
        return chefOrderDishDtos;

    }

    @Transactional
    public void insert(ChefOrderDishDto chefOrderDishDto) {

        ChefOrderDish chefOrderDish = chefOrderDishMapper.mapToEntity(chefOrderDishDto);
        chefOrderDishRepository.insert(chefOrderDish.getCount(), chefOrderDish.getPrice(), chefOrderDish.getChefId(), chefOrderDish.getOrderId(), chefOrderDish.getDishId());

    }

    @Transactional
    public void udpate(Integer id, Integer count) {

        chefOrderDishRepository.updateById(id, count);

    }

    @Transactional
    public void deleteById(Integer id) {

        chefOrderDishRepository.deleteById(id);

    }

}
