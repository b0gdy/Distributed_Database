package com.example.modbd.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "TYPES")
public class Type {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "MIN_SALARY")
    private Integer minSalary;
    @Column(name = "MAX_SALARY")
    private Integer maxSalary;

    @OneToMany(mappedBy="type")
    private List<Employee> employees;

}
