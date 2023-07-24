package com.foodcourt.final1912074.data.dto;

import com.foodcourt.final1912074.data.entity.FoodCorner;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FoodMenuResponseDto {
    private Long menuNum;
    private String menuName;
    private Long menuPrice;
    private Long cornerNum;

}
