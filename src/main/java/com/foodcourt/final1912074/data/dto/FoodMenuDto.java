package com.foodcourt.final1912074.data.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class FoodMenuDto {
    private String menuName;
    private Long menuPrice;
    private Long cornerNum;
}
