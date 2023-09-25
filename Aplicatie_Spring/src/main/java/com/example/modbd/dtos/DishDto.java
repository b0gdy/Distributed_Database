package com.example.modbd.dtos;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DishDto {

    private Integer id;
    private String name;
    private Integer price;
    private Integer menuId;

}
