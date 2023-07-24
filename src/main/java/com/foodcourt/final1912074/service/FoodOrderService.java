package com.foodcourt.final1912074.service;

import com.foodcourt.final1912074.data.dto.FoodOrderDto;
import com.foodcourt.final1912074.data.dto.FoodOrderResponseDto;
import com.foodcourt.final1912074.data.entity.FoodOrder;

import java.util.List;

public interface FoodOrderService {
    List<FoodOrder> getAllCustomerNum(FoodOrder customerNum);
    List<FoodOrder> getAllOrder();
    FoodOrderResponseDto saveFoodOrder(FoodOrderDto foodOrderDto);
    void deleteFoodOrder(Long orderId) throws Exception;
}
