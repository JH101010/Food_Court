package com.foodcourt.final1912074.service;

import com.foodcourt.final1912074.data.dto.FoodMenuDto;
import com.foodcourt.final1912074.data.dto.FoodMenuResponseDto;
import com.foodcourt.final1912074.data.entity.FoodCorner;
import com.foodcourt.final1912074.data.entity.FoodMenu;

import java.util.List;

public interface FoodMenuService {
    List<FoodMenu> getAllFoodMenu(FoodCorner cornerNum);
    List<FoodMenu> getAllMenu();
    FoodMenuResponseDto saveFoodMenu(FoodMenuDto foodMenuDto);

    FoodMenuDto saveFoodMenu1(FoodMenuDto foodMenuDto);
    FoodMenuResponseDto updateFoodMenuPrice(Long menuNum, Long menuPrice) throws Exception;
    void deleteFoodMenu(Long menuNum) throws Exception;
}
