package com.example.modbd.dtos;

import lombok.*;

import javax.persistence.Column;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RestaurantDto {

    private Integer id;
    private String name;
    private Integer cityId;

}
