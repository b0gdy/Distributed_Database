package com.example.modbd.repository;

import com.example.modbd.entities.Drink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DrinkRepository extends JpaRepository<Drink, Integer> {

    @Query(value = "SELECT * FROM drinks", nativeQuery = true)
    List<Drink> findAll();

    @Query(value = "SELECT * FROM drinks WHERE id = :id", nativeQuery = true)
    Optional<Drink> findById(Integer id);

    @Query(value = "SELECT * FROM drinks WHERE menu_id = :menuId", nativeQuery = true)
    List<Drink> findByMenu(Integer menuId);

    @Modifying
    @Query(value = "INSERT INTO drinks (name, price, menu_id, type) VALUES (:name, :price, :menuId, :type)", nativeQuery = true)
    void insert(String name, Integer price, Integer menuId, String type);

    @Modifying
    @Query(value = "UPDATE drinks SET name = :name, price = :price, type = :type WHERE id = :id", nativeQuery = true)
    void updateById(Integer id, String name, Integer price, String type);

    @Modifying
    @Query(value = "DELETE FROM drinks WHERE id = :id", nativeQuery = true)
    void deleteById(Integer id);

}
