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
@Table(name = "ORDERS_DRINKS")
public class OrderDrink {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "COUNT")
    private Integer count;
    @Column(name = "PRICE")
    private Integer price;
    @Column(name = "ORDER_ID")
    private Integer orderId;
    @Column(name = "DRINK_ID")
    private Integer drinkId;

    @ManyToOne
    @JoinColumn(name="ORDER_ID", insertable = false, updatable = false, nullable = false)
    private Order order;
    @ManyToOne
    @JoinColumn(name="DRINK_ID", insertable = false, updatable = false, nullable = false)
    private Drink drink;

}
