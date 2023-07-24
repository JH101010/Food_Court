package com.foodcourt.final1912074.data.dao;

import com.foodcourt.final1912074.data.entity.FoodCorner;

import java.util.List;

public interface FoodCornerDAO {
    FoodCorner insertFoodCorner(FoodCorner foodCorner);

    FoodCorner selectFoodCorner(Long cornerNum);

    List<FoodCorner> getAllFoodCorner();

    FoodCorner updateCornerName(Long cornerNum, String cornerName) throws Exception;
    void deleteFoodCorner(Long cornerNum) throws Exception;
}
