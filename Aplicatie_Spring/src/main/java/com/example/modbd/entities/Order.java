package com.example.modbd.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "ORDERS")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "ORDER_DATE")
    private LocalDateTime orderDate;
    @Column(name = "TOTAL")
    private Integer total;
    @Column(name = "TIP")
    private Integer tip;
    @Column(name = "WAITER_ID")
    private Integer waiterId;

    @ManyToOne
    @JoinColumn(name="WAITER_ID", insertable = false, updatable = false, nullable = false)
    private Employee employee;

    @OneToMany(mappedBy="order")
    private List<OrderDrink> orderDrinks;
    @OneToMany(mappedBy="order")
    private List<ChefOrderDish> chefOrderDishes;

}
