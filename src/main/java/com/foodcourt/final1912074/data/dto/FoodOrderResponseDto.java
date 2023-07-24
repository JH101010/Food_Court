package com.foodcourt.final1912074.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FoodOrderResponseDto {
    private Long orderId;
    private Long menuPrice;
    private String menuName;
    private Long customerNum;
    private Long menuNum;
}
