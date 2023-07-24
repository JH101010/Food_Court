package com.foodcourt.final1912074.data.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class FoodOrderDto {
    private Long menuPrice;
    private String menuName;
    private Long customerNum;
    private Long menuNum;
}
