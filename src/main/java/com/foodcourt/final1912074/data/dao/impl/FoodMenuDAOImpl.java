package com.foodcourt.final1912074.data.dao.impl;

import com.foodcourt.final1912074.data.dao.FoodMenuDAO;
import com.foodcourt.final1912074.data.entity.FoodCorner;
import com.foodcourt.final1912074.data.entity.FoodMenu;
import com.foodcourt.final1912074.data.repository.FoodMenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class FoodMenuDAOImpl implements FoodMenuDAO {

    private FoodMenuRepository foodMenuRepository;

    @Autowired
    public FoodMenuDAOImpl(FoodMenuRepository foodMenuRepository) {
        this.foodMenuRepository = foodMenuRepository;
    }
    @Override
    public FoodMenu insertFoodMenu(FoodMenu foodMenu) {
        FoodMenu savedFoodMenu = foodMenuRepository.save(foodMenu);
        return savedFoodMenu;
    }

    @Override
    public List<FoodMenu> getAllFoodMenu() {
        List<FoodMenu> lists = foodMenuRepository.findAll();
        return lists;
    }

    @Override
    public FoodMenu updateFoodMenuPrice(Long menuNum, Long menuPrice) throws Exception {
        Optional<FoodMenu> selectedFoodMenu = foodMenuRepository.findById(menuNum);

        FoodMenu updatedFoodMenu;
        if(selectedFoodMenu.isPresent()) {
            FoodMenu foodMenu = selectedFoodMenu.get();

            foodMenu.setMenuPrice(menuPrice);

            updatedFoodMenu = foodMenuRepository.save(foodMenu);
        } else {
            throw new Exception();
        }
        return updatedFoodMenu;
    }

    @Override
    public void deleteFoodMenu(Long menuNum) throws Exception {
        Optional<FoodMenu> selectedFoodMenu = foodMenuRepository.findById(menuNum);

        if(selectedFoodMenu.isPresent()) {
            FoodMenu foodMenu = selectedFoodMenu.get();

            foodMenuRepository.delete(foodMenu);
        } else {
            throw new Exception();
        }
    }
}
