package com.foodcourt.final1912074.service.impl;

import com.foodcourt.final1912074.data.dao.FoodCornerDAO;
import com.foodcourt.final1912074.data.dto.FoodCornerDto;
import com.foodcourt.final1912074.data.dto.FoodCornerResponseDto;
import com.foodcourt.final1912074.data.entity.FoodCorner;
import com.foodcourt.final1912074.service.FoodCornerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FoodCornerServiceImpl implements FoodCornerService {

    private final FoodCornerDAO foodCornerDAO;

    @Autowired
    public FoodCornerServiceImpl(FoodCornerDAO foodCornerDAO) {
        this.foodCornerDAO = foodCornerDAO;
    }


    @Override
    public List<FoodCorner> getAllFoodCorner() {
        List<FoodCorner> lists = foodCornerDAO.getAllFoodCorner();
        List<FoodCorner> list = new ArrayList<>();

        for(FoodCorner f : lists) {
            FoodCorner foodCorner = new FoodCorner();
            foodCorner.setCornerNum(f.getCornerNum());
            foodCorner.setCornerName(f.getCornerName());

            list.add(foodCorner);
        }
        return list;
    }

    @Override
    public FoodCornerResponseDto saveFoodCorner(FoodCornerDto foodCornerDto) {
        FoodCorner foodCorner = new FoodCorner();
        foodCorner.setCornerName(foodCornerDto.getCornerName());

        FoodCorner savedFoodCorner = foodCornerDAO.insertFoodCorner(foodCorner);

        FoodCornerResponseDto foodCornerResponseDto = new FoodCornerResponseDto();
        foodCornerResponseDto.setCornerNum(savedFoodCorner.getCornerNum());
        foodCornerResponseDto.setCornerName(savedFoodCorner.getCornerName());

        return foodCornerResponseDto;
    }

    @Override
    public void deleteFoodCorner(Long cornerNum) throws Exception {
        foodCornerDAO.deleteFoodCorner(cornerNum);
    }
}
