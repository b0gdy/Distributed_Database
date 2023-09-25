package com.example.modbd.repository;

import com.example.modbd.entities.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TypeRepository extends JpaRepository<Type, Integer> {

    @Query(value = "SELECT * FROM types", nativeQuery = true)
    List<Type> findAll();

    @Query(value = "SELECT * FROM types WHERE id = :id", nativeQuery = true)
    Optional<Type> findById(Integer id);

    @Modifying
    @Query(value = "INSERT INTO types (name, min_salary, max_salary) VALUES (:name, :minSalary, :maxSalary)", nativeQuery = true)
    void insert(String name, Integer minSalary, Integer maxSalary);

    @Modifying
    @Query(value = "UPDATE types SET name = :name, min_salary = :minSalary, max_salary = :maxSalary WHERE id = :id", nativeQuery = true)
    void updateById(Integer id, String name, Integer minSalary, Integer maxSalary);

    @Modifying
    @Query(value = "DELETE FROM types WHERE id = :id", nativeQuery = true)
    void deleteById(Integer id);

}
