package com.example.modbd.repository;

import com.example.modbd.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {

    @Query(value = "SELECT * FROM cities", nativeQuery = true)
    List<City> findAll();

    @Query(value = "SELECT * FROM cities WHERE id = :id", nativeQuery = true)
    Optional<City> findById(Integer id);

    @Modifying
    @Query(value = "INSERT INTO cities (name, region) VALUES (:name, :region)", nativeQuery = true)
    void insert(String name, String region);

    @Modifying
    @Query(value = "UPDATE cities SET name = :name WHERE id = :id", nativeQuery = true)
    void updateById(Integer id, String name);

    @Modifying
    @Query(value = "DELETE FROM cities WHERE id = :id", nativeQuery = true)
    void deleteById(Integer id);

}
