package com.foodcourt.final1912074.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FoodCornerResponseDto {
    private Long cornerNum;
    private String cornerName;
}
