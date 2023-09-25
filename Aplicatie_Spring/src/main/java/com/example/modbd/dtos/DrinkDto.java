package com.example.modbd.dtos;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DrinkDto {

    private Integer id;
    private String name;
    private String type;
    private Integer price;
    private Integer menuId;

}
