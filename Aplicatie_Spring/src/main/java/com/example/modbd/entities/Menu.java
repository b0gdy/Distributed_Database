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
@Table(name = "MENUS")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "MENU_DATE")
    private LocalDate menuDate;

    @OneToMany(mappedBy="menu")
    private List<Drink> drinks;
    @OneToMany(mappedBy="menu")
    private List<Dish> dishes;

}
