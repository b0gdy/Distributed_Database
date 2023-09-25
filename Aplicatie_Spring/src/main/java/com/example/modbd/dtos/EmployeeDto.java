package com.example.modbd.dtos;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeDto {

    private Integer id;
    private String name;
    private Integer salary;
    private String hireDate;
    private Integer typeId;
    private Integer restaurantId;

}
