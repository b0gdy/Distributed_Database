package com.example.modbd.dtos;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDrinkDto {

    private Integer id;
    private Integer count;
    private Integer price;
    private Integer orderId;
    private Integer drinkId;

}
