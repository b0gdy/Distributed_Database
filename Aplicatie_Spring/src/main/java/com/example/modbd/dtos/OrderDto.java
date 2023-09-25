package com.example.modbd.dtos;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDto {

    private Integer id;
    private String orderDate;
    private Integer total;
    private Integer tip;
    private Integer waiterId;

}
