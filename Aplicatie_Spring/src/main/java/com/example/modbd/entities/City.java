package com.example.modbd.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "CITIES")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "REGION")
    private String region;

    @OneToMany(mappedBy="city")
    private List<Restaurant> restaurants;

}
