package com.example.modbd.repository;

import com.example.modbd.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    @Query(value = "SELECT * FROM orders", nativeQuery = true)
    List<Order> findAll();

    @Query(value = "SELECT * FROM orders WHERE id = :id", nativeQuery = true)
    Optional<Order> findById(Integer id);

    @Query(value = "SELECT * FROM orders WHERE waiter_id = :waiterId", nativeQuery = true)
    List<Order> findByWaiter(Integer waiterId);

    @Modifying
    @Query(value = "INSERT INTO orders (order_date, total, tip, waiter_id) VALUES (:orderDate, :total, :tip, :waiterId)", nativeQuery = true)
    void insert(LocalDateTime orderDate, Integer total, Integer tip, Integer waiterId);

    @Modifying
    @Query(value = "UPDATE orders SET tip = :tip WHERE id = :id", nativeQuery = true)
    void updateById(Integer id, Integer tip);

    @Modifying
    @Query(value = "DELETE FROM orders WHERE id = :id", nativeQuery = true)
    void deleteById(Integer id);

}
