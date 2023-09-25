package com.example.modbd.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "DRINKS")
public class Drink {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "TYPE")
    private String type;
    @Column(name = "PRICE")
    private Integer price;
    @Column(name = "MENU_ID")
    private Integer menuId;

    @ManyToOne
    @JoinColumn(name="MENU_ID", insertable = false, updatable = false, nullable = false)
    private Menu menu;

    @OneToMany(mappedBy="drink")
    private List<OrderDrink> orderDrinks;

}
