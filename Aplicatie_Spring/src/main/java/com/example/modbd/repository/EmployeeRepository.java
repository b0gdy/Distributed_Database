package com.example.modbd.repository;

import com.example.modbd.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query(value = "SELECT * FROM employees", nativeQuery = true)
    List<Employee> findAll();

    @Query(value = "SELECT * FROM employees WHERE id = :id", nativeQuery = true)
    Optional<Employee> findById(Integer id);

    @Query(value = "SELECT * FROM employees WHERE type_id = :typeId", nativeQuery = true)
    List<Employee> findByType(Integer typeId);

    @Query(value = "SELECT * FROM employees WHERE restaurant_id = :restaurantId", nativeQuery = true)
    List<Employee> findByRestaurant(Integer restaurantId);

    @Modifying
    @Query(value = "INSERT INTO employees (name, salary, hire_date, type_id, restaurant_id) VALUES (:name, :salary, :hireDate, :typeId, :restaurantId)", nativeQuery = true)
    void insert(String name, Integer salary, LocalDate hireDate, Integer typeId, Integer restaurantId);

    @Modifying
    @Query(value = "UPDATE employees SET name = :name, salary = :salary, hire_date = :hireDate, type_id = :typeId WHERE id = :id", nativeQuery = true)
    void updateById(Integer id, String name, Integer salary, LocalDate hireDate, Integer typeId);

    @Modifying
    @Query(value = "DELETE FROM employees WHERE id = :id", nativeQuery = true)
    void deleteById(Integer id);

}
