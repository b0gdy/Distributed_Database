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
@Table(name = "RESTAURANTS")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "CITY_ID")
    private Integer cityId;

    @ManyToOne
    @JoinColumn(name="CITY_ID", insertable = false, updatable = false, nullable = false)
    private City city;

}
