package com.foodcourt.final1912074.service.impl;

import com.foodcourt.final1912074.data.dao.FoodOrderDAO;
import com.foodcourt.final1912074.data.dto.FoodOrderDto;
import com.foodcourt.final1912074.data.dto.FoodOrderResponseDto;
import com.foodcourt.final1912074.data.entity.Customer;
import com.foodcourt.final1912074.data.entity.FoodMenu;
import com.foodcourt.final1912074.data.entity.FoodOrder;
import com.foodcourt.final1912074.service.FoodOrderService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FoodOrderServiceImpl implements FoodOrderService {
    private final FoodOrderDAO foodOrderDAO;

    @Autowired
    public FoodOrderServiceImpl(FoodOrderDAO foodOrderDAO) {
        this.foodOrderDAO = foodOrderDAO;
    }

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<FoodOrder> getAllCustomerNum(FoodOrder customerNum) {
        List<FoodOrder> lists = foodOrderDAO.getAllFoodOrder();
        List<FoodOrder> list = new ArrayList<>();
        for(FoodOrder f : lists) {
            FoodOrder foodOrder = new FoodOrder();
            foodOrder.setOrderId(f.getOrderId());
            foodOrder.setMenuPrice(f.getMenuPrice());
            foodOrder.setMenuName(f.getMenuName());
            foodOrder.setCustomerNum(f.getCustomerNum());
            foodOrder.setMenuNum(f.getMenuNum());

            list.add(foodOrder);
        }
        return list;
    }

    @Override
    public List<FoodOrder> getAllOrder() {
        List<FoodOrder> lists = foodOrderDAO.getAllFoodOrder();
        List<FoodOrder> list = new ArrayList<>();
        for(FoodOrder f : lists) {
            FoodOrder foodOrder = new FoodOrder();
            foodOrder.setOrderId(f.getOrderId());
            foodOrder.setCustomerNum(f.getCustomerNum());
            foodOrder.setMenuNum(f.getMenuNum());
            foodOrder.setMenuPrice(f.getMenuPrice());
            foodOrder.setMenuName(f.getMenuName());
            list.add(foodOrder);
        }
        return list;
    }

    @Override
    public FoodOrderResponseDto saveFoodOrder(FoodOrderDto foodOrderDto) {
        FoodOrder foodOrder = new FoodOrder();
        foodOrder.setMenuPrice(foodOrderDto.getMenuPrice());
        foodOrder.setMenuName(foodOrderDto.getMenuName());

        Customer customer = new Customer();
        customer.setCustomerNum(foodOrderDto.getCustomerNum());
        foodOrder.setCustomerNum(customer);

        FoodMenu foodMenu = new FoodMenu();
        foodMenu.setMenuNum(foodOrderDto.getMenuNum());
        foodOrder.setMenuNum(foodMenu);

        FoodOrder savedFoodOrder = foodOrderDAO.insertFoodOrder(foodOrder);

        FoodOrderResponseDto foodOrderResponseDto = new FoodOrderResponseDto();
        foodOrderResponseDto.setOrderId(savedFoodOrder.getOrderId());
        foodOrderResponseDto.setMenuPrice(savedFoodOrder.getMenuPrice());
        foodOrderResponseDto.setMenuName(savedFoodOrder.getMenuName());
        foodOrderResponseDto.setMenuNum(savedFoodOrder.getMenuNum().getMenuNum());
        foodOrderResponseDto.setCustomerNum(savedFoodOrder.getCustomerNum().getCustomerNum());

        return foodOrderResponseDto;
    }

    @Override
    public void deleteFoodOrder(Long orderId) throws Exception {
        foodOrderDAO.deleteFoodOrder(orderId);
    }
}
