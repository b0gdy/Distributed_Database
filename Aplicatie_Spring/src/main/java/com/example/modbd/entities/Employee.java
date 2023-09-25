package com.example.modbd.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "EMPLOYEES")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "SALARY")
    private Integer salary;
    @Column(name = "HIRE_DATE")
    private LocalDate hireDate;
    @Column(name = "TYPE_ID")
    private Integer typeId;
    @Column(name = "RESTAURANT_ID")
    private Integer restaurantId;

    @ManyToOne
    @JoinColumn(name="TYPE_ID", insertable = false, updatable = false, nullable = false)
    private Type type;
    @ManyToOne
    @JoinColumn(name="RESTAURANT_ID", insertable = false, updatable = false, nullable = false)
    private Restaurant restaurant;

    @OneToMany(mappedBy="employee")
    private List<Order> orders;
    @OneToMany(mappedBy="employee")
    private List<ChefOrderDish> chefOrderDishes;

}
