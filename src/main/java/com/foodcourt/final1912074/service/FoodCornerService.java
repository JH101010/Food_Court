package com.foodcourt.final1912074.service;

import com.foodcourt.final1912074.data.dto.FoodCornerDto;
import com.foodcourt.final1912074.data.dto.FoodCornerResponseDto;
import com.foodcourt.final1912074.data.entity.FoodCorner;

import java.util.List;

public interface FoodCornerService {
    List<FoodCorner> getAllFoodCorner();

    FoodCornerResponseDto saveFoodCorner(FoodCornerDto foodCornerDto);

    void deleteFoodCorner(Long cornerNum) throws Exception;
}
