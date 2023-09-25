package com.example.modbd.repository;

import com.example.modbd.entities.OrderDrink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderDrinkRepository extends JpaRepository<OrderDrink, Integer> {

    @Query(value = "SELECT * FROM orders_drinks", nativeQuery = true)
    List<OrderDrink> findAll();

    @Query(value = "SELECT * FROM orders_drinks WHERE id = :id", nativeQuery = true)
    Optional<OrderDrink> findById(Integer id);

    @Query(value = "SELECT * FROM orders_drinks WHERE order_id = :orderId", nativeQuery = true)
    List<OrderDrink> findByOrder(Integer orderId);

    @Query(value = "SELECT * FROM orders_drinks WHERE drink_id = :drinkId", nativeQuery = true)
    List<OrderDrink> findByDrink(Integer drinkId);

    @Modifying
    @Query(value = "INSERT INTO orders_drinks (count, price, order_id, drink_id) VALUES (:count, :price, :orderId, :drinkId)", nativeQuery = true)
    void insert(Integer count, Integer price, Integer orderId, Integer drinkId);

    @Modifying
    @Query(value = "UPDATE orders_drinks SET count = :count WHERE id = :id", nativeQuery = true)
    void updateById(Integer id, Integer count);

    @Modifying
    @Query(value = "DELETE FROM orders_drinks WHERE id = :id", nativeQuery = true)
    void deleteById(Integer id);

}
