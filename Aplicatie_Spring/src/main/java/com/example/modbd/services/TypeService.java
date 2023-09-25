package com.example.modbd.services;

import com.example.modbd.dtos.TypeDto;
import com.example.modbd.entities.Type;
import com.example.modbd.mappers.TypeMapper;
import com.example.modbd.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TypeService {

    @Autowired
    TypeRepository typeRepository;

    @Autowired
    TypeMapper typeMapper;

    public List<TypeDto> getAll() {

        List<Type> types = typeRepository.findAll();
        List<TypeDto> typeDtos = new ArrayList<>();
        for (Type type : types) {
            TypeDto typeDto = typeMapper.mapToDto(type);
            typeDtos.add(typeDto);
        }
        return typeDtos;

    }

    public TypeDto getById(Integer id) {

        Optional<Type> type = typeRepository.findById(id);
        TypeDto typeDto = typeMapper.mapToDto(type.get());
        return typeDto;

    }

    @Transactional
    public void insert(TypeDto typeDto) {

        Type type = typeMapper.mapToEntity(typeDto);
        typeRepository.insert(type.getName(), type.getMinSalary(), type.getMaxSalary());

    }

    @Transactional
    public void udpate(Integer id, String name, Integer minSalary, Integer maxSalary) {

        typeRepository.updateById(id, name, minSalary, maxSalary);

    }

    @Transactional
    public void deleteById(Integer id) {

        typeRepository.deleteById(id);

    }


}
