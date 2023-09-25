package com.example.modbd.dtos;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TypeDto {

    private Integer id;
    private String name;
    private Integer minSalary;
    private Integer maxSalary;

}
