package com.foodcourt.final1912074.data.dao.impl;

import com.foodcourt.final1912074.data.dao.FoodOrderDAO;
import com.foodcourt.final1912074.data.entity.FoodOrder;
import com.foodcourt.final1912074.data.repository.FoodOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class FoodOrderDAOImpl implements FoodOrderDAO {
    private FoodOrderRepository foodOrderRepository;

    @Autowired
    public FoodOrderDAOImpl(FoodOrderRepository foodOrderRepository) {
        this.foodOrderRepository = foodOrderRepository;
    }
    @Override
    public FoodOrder insertFoodOrder(FoodOrder foodOrder) {
        FoodOrder savedFoodOrder = foodOrderRepository.save(foodOrder);
        return savedFoodOrder;
    }

    @Override
    public List<FoodOrder> getAllFoodOrder() {
        List<FoodOrder> lists = foodOrderRepository.findAll();
        return lists;
    }

    @Override
    public void deleteFoodOrder(Long customerNum) throws Exception {
        Optional<FoodOrder> selectedFoodOrder = foodOrderRepository.findById(customerNum);

        if(selectedFoodOrder.isPresent()) {
            FoodOrder foodOrder = selectedFoodOrder.get();

            foodOrderRepository.delete(foodOrder);
        } else {
            throw new Exception();
        }
    }
}
