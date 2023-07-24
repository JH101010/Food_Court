package com.foodcourt.final1912074.data.dao.impl;

import com.foodcourt.final1912074.data.dao.FoodCornerDAO;
import com.foodcourt.final1912074.data.entity.FoodCorner;
import com.foodcourt.final1912074.data.repository.FoodCornerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class FoodCornerDAOImpl implements FoodCornerDAO {

    private FoodCornerRepository foodCornerRepository;

    @Autowired
    public FoodCornerDAOImpl(FoodCornerRepository foodCornerRepository) { this.foodCornerRepository = foodCornerRepository;}

    @Override
    public FoodCorner insertFoodCorner(FoodCorner foodCorner) {
        FoodCorner savedFoodCorner = foodCornerRepository.save(foodCorner);
        return savedFoodCorner;
    }

    @Override
    public FoodCorner selectFoodCorner(Long cornerNum) {
        FoodCorner selectedFoodCorner = foodCornerRepository.getById(cornerNum);
        return selectedFoodCorner;
    }

    @Override
    public List<FoodCorner> getAllFoodCorner() {
        List<FoodCorner> lists = foodCornerRepository.findAll();
        return lists;
    }

    @Override
    public FoodCorner updateCornerName(Long cornerNum, String cornerName) throws Exception {
        Optional<FoodCorner> selectedFoodCorner = foodCornerRepository.findById(cornerNum);

        FoodCorner updatedFoodCorner;
        if(selectedFoodCorner.isPresent()) {
            FoodCorner foodCorner = selectedFoodCorner.get();

            foodCorner.setCornerName(cornerName);

            updatedFoodCorner = foodCornerRepository.save(foodCorner);
        }else {
            throw new Exception();
        }
        return updatedFoodCorner;
    }

    @Override
    public void deleteFoodCorner(Long cornerNum) throws Exception {
        Optional<FoodCorner> selectedFoodCorner = foodCornerRepository.findById(cornerNum);

        if(selectedFoodCorner.isPresent()) {
            FoodCorner foodCorner = selectedFoodCorner.get();

            foodCornerRepository.delete(foodCorner);
        } else {
            throw new Exception();
        }
    }
}
