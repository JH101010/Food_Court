package com.foodcourt.final1912074.data.dao;

import com.foodcourt.final1912074.data.entity.FoodOrder;

import java.util.List;

public interface FoodOrderDAO{
    FoodOrder insertFoodOrder(FoodOrder foodOrder);
    List<FoodOrder> getAllFoodOrder();
    void deleteFoodOrder(Long customerNum) throws Exception;
}
