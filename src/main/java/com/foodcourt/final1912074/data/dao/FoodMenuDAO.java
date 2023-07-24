package com.foodcourt.final1912074.data.dao;

import com.foodcourt.final1912074.data.entity.FoodMenu;

import java.util.List;

public interface FoodMenuDAO {
    FoodMenu insertFoodMenu(FoodMenu foodMenu);

    List<FoodMenu>  getAllFoodMenu();

    FoodMenu updateFoodMenuPrice(Long menuNum, Long menuPrice) throws Exception;

    void deleteFoodMenu(Long menuNum) throws Exception;
}
