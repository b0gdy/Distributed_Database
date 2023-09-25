package com.example.modbd.services;

import com.example.modbd.dtos.CityDto;
import com.example.modbd.entities.City;
import com.example.modbd.mappers.CityMapper;
import com.example.modbd.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CityService {

    @Autowired
    CityRepository cityRepository;
    
    @Autowired
    CityMapper cityMapper;

    public List<CityDto> getAll() {

        List<City> cities = cityRepository.findAll();
        List<CityDto> cityDtos = new ArrayList<>();
        for (City city : cities) {
            CityDto cityDto = cityMapper.mapToDto(city);
            cityDtos.add(cityDto);
        }
        return cityDtos;

    }

    public CityDto getById(Integer id) {

        Optional<City> city = cityRepository.findById(id);
        CityDto cityDto = cityMapper.mapToDto(city.get());
        return cityDto;

    }

    @Transactional
    public void insert(CityDto cityDto) {

        City city = cityMapper.mapToEntity(cityDto);
        cityRepository.insert(city.getName(), city.getRegion());

    }

    @Transactional
    public void udpate(Integer id, String name) {

        cityRepository.updateById(id, name);

    }

    @Transactional
    public void deleteById(Integer id) {

        cityRepository.deleteById(id);

    }


}
