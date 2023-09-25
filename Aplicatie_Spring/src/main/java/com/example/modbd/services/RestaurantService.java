package com.example.modbd.services;

import com.example.modbd.dtos.RestaurantDto;
import com.example.modbd.entities.Restaurant;
import com.example.modbd.mappers.RestaurantMapper;
import com.example.modbd.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {

    @Autowired
    RestaurantRepository restaurantRepository;

    @Autowired
    RestaurantMapper restaurantMapper;

    public List<RestaurantDto> getAll() {

        List<Restaurant> restaurants = restaurantRepository.findAll();
        List<RestaurantDto> restaurantDtos = new ArrayList<>();
        for (Restaurant restaurant : restaurants) {
            RestaurantDto restaurantDto = restaurantMapper.mapToDto(restaurant);
            restaurantDtos.add(restaurantDto);
        }
        return restaurantDtos;

    }

    public RestaurantDto getById(Integer id) {

        Optional<Restaurant> restaurant = restaurantRepository.findById(id);
        RestaurantDto restaurantDto = restaurantMapper.mapToDto(restaurant.get());
        return restaurantDto;

    }

    public List<RestaurantDto> getByCity(Integer cityId) {

        List<Restaurant> restaurants = restaurantRepository.findByCity(cityId);
        List<RestaurantDto> restaurantDtos = new ArrayList<>();
        for (Restaurant restaurant : restaurants) {
            RestaurantDto restaurantDto = restaurantMapper.mapToDto(restaurant);
            restaurantDtos.add(restaurantDto);
        }
        return restaurantDtos;

    }

    @Transactional
    public void insert(RestaurantDto restaurantDto) {

        Restaurant restaurant = restaurantMapper.mapToEntity(restaurantDto);
        restaurantRepository.insert(restaurant.getName(), restaurant.getCityId());

    }

    @Transactional
    public void udpate(Integer id, String name) {

        restaurantRepository.updateById(id, name);

    }

    @Transactional
    public void deleteById(Integer id) {

        restaurantRepository.deleteById(id);

    }


}