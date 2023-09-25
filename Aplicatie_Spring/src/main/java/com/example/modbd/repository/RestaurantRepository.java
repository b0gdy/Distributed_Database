package com.example.modbd.repository;

import com.example.modbd.entities.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {

    @Query(value = "SELECT * FROM restaurants", nativeQuery = true)
    List<Restaurant> findAll();

    @Query(value = "SELECT * FROM restaurants WHERE id = :id", nativeQuery = true)
    Optional<Restaurant> findById(Integer id);

    @Query(value = "SELECT * FROM restaurants WHERE city_id = :cityId", nativeQuery = true)
    List<Restaurant> findByCity(Integer cityId);

    @Modifying
    @Query(value = "INSERT INTO restaurants (name, city_id) VALUES (:name, :cityId)", nativeQuery = true)
    void insert(String name, Integer cityId);

    @Modifying
    @Query(value = "UPDATE restaurants SET name = :name WHERE id = :id", nativeQuery = true)
    void updateById(Integer id, String name);

    @Modifying
    @Query(value = "DELETE FROM restaurants WHERE id = :id", nativeQuery = true)
    void deleteById(Integer id);

}
