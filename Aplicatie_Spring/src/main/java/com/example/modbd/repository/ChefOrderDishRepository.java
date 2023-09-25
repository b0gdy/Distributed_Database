package com.example.modbd.repository;

import com.example.modbd.entities.ChefOrderDish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ChefOrderDishRepository extends JpaRepository<ChefOrderDish, Integer> {

    @Query(value = "SELECT * FROM chefs_orders_dishes", nativeQuery = true)
    List<ChefOrderDish> findAll();

    @Query(value = "SELECT * FROM chefs_orders_dishes WHERE id = :id", nativeQuery = true)
    Optional<ChefOrderDish> findById(Integer id);

    @Query(value = "SELECT * FROM chefs_orders_dishes WHERE chef_id = :chefId", nativeQuery = true)
    List<ChefOrderDish> findByChef(Integer chefId);

    @Query(value = "SELECT * FROM chefs_orders_dishes WHERE order_id = :orderId", nativeQuery = true)
    List<ChefOrderDish> findByOrder(Integer orderId);

    @Query(value = "SELECT * FROM chefs_orders_dishes WHERE dish_id = :dishId", nativeQuery = true)
    List<ChefOrderDish> findByDish(Integer dishId);

    @Modifying
    @Query(value = "INSERT INTO chefs_orders_dishes (count, price, chef_id, order_id, dish_id) VALUES (:count, :price, :chefId, :orderId, :dishId)", nativeQuery = true)
    void insert(Integer count, Integer price, Integer chefId, Integer orderId, Integer dishId);

    @Modifying
    @Query(value = "UPDATE chefs_orders_dishes SET count = :count WHERE id = :id", nativeQuery = true)
    void updateById(Integer id, Integer count);

    @Modifying
    @Query(value = "DELETE FROM chefs_orders_dishes WHERE id = :id", nativeQuery = true)
    void deleteById(Integer id);

}
