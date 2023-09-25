package com.example.modbd.entities;

import lombok.*;

import javax.persistence.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "CHEFS_ORDERS_DISHES")
public class ChefOrderDish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "COUNT")
    private Integer count;
    @Column(name = "PRICE")
    private Integer price;
    @Column(name = "CHEF_ID")
    private Integer chefId;
    @Column(name = "ORDER_ID")
    private Integer orderId;
    @Column(name = "DISH_ID")
    private Integer dishId;

    @ManyToOne
    @JoinColumn(name="CHEF_ID", insertable = false, updatable = false, nullable = false)
    private Employee employee;
    @ManyToOne
    @JoinColumn(name="ORDER_ID", insertable = false, updatable = false, nullable = false)
    private Order order;
    @ManyToOne
    @JoinColumn(name="DISH_ID", insertable = false, updatable = false, nullable = false)
    private Dish dish;
    
}
