package com.example.modbd.dtos;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChefOrderDishDto {

    private Integer id;
    private Integer count;
    private Integer price;
    private Integer chefId;
    private Integer orderId;
    private Integer dishId;

}
