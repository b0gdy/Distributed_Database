package com.example.modbd.repository;

import com.example.modbd.entities.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DishRepository extends JpaRepository<Dish, Integer> {

    @Query(value = "SELECT * FROM dishes", nativeQuery = true)
    List<Dish> findAll();

    @Query(value = "SELECT * FROM dishes WHERE id = :id", nativeQuery = true)
    Optional<Dish> findById(Integer id);

    @Query(value = "SELECT * FROM dishes WHERE menu_id = :menuId", nativeQuery = true)
    List<Dish> findByMenu(Integer menuId);

    @Modifying
    @Query(value = "INSERT INTO dishes (name, price, menu_id) VALUES (:name, :price, :menuId)", nativeQuery = true)
    void insert(String name, Integer price, Integer menuId);

    @Modifying
    @Query(value = "UPDATE dishes SET name = :name, price = :price WHERE id = :id", nativeQuery = true)
    void updateById(Integer id, String name, Integer price);

    @Modifying
    @Query(value = "DELETE FROM dishes WHERE id = :id", nativeQuery = true)
    void deleteById(Integer id);

}
