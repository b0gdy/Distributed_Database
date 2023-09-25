package com.example.modbd.repository;

import com.example.modbd.entities.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer> {

    @Query(value = "SELECT * FROM menus", nativeQuery = true)
    List<Menu> findAll();

    @Query(value = "SELECT * FROM menus WHERE id = :id", nativeQuery = true)
    Optional<Menu> findById(Integer id);

    @Modifying
    @Query(value = "INSERT INTO menus (menu_date) VALUES (:menuDate)", nativeQuery = true)
    void insert(LocalDate menuDate);

    @Modifying
    @Query(value = "UPDATE menus SET menu_date = :menuDate WHERE id = :id", nativeQuery = true)
    void updateById(Integer id, LocalDate menuDate);

    @Modifying
    @Query(value = "DELETE FROM menus WHERE id = :id", nativeQuery = true)
    void deleteById(Integer id);

}
