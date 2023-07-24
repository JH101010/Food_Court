package com.foodcourt.final1912074.service.impl;

import com.foodcourt.final1912074.data.dao.FoodMenuDAO;
import com.foodcourt.final1912074.data.dto.FoodMenuDto;
import com.foodcourt.final1912074.data.dto.FoodMenuResponseDto;
import com.foodcourt.final1912074.data.entity.Customer;
import com.foodcourt.final1912074.data.entity.FoodCorner;
import com.foodcourt.final1912074.data.entity.FoodMenu;
import com.foodcourt.final1912074.service.FoodMenuService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FoodMenuServiceImpl implements FoodMenuService {
    private final FoodMenuDAO foodMenuDAO;

    @Autowired
    public FoodMenuServiceImpl(FoodMenuDAO foodMenuDAO) {
        this.foodMenuDAO = foodMenuDAO;
    }

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<FoodMenu> getAllFoodMenu(FoodCorner cornerNum) {
        List<FoodMenu> lists = foodMenuDAO.getAllFoodMenu();
        List<FoodMenu> list = new ArrayList<>();
        for(FoodMenu f : lists) {
            FoodMenu foodMenu = new FoodMenu();
            foodMenu.setMenuNum(f.getMenuNum());
            foodMenu.setMenuName(f.getMenuName());
            foodMenu.setMenuPrice(f.getMenuPrice());
            foodMenu.setCornerNum(cornerNum);

            list.add(foodMenu);
        }
        return list;
    }

    @Override
    public List<FoodMenu> getAllMenu() {
        List<FoodMenu> lists = foodMenuDAO.getAllFoodMenu();
        List<FoodMenu> list = new ArrayList<>();
        for(FoodMenu f : lists) {
            FoodMenu foodMenu = new FoodMenu();
            foodMenu.setMenuNum(f.getMenuNum());
            foodMenu.setMenuName(f.getMenuName());
            foodMenu.setMenuPrice(f.getMenuPrice());
            foodMenu.setCornerNum(f.getCornerNum());
            list.add(foodMenu);
        }
        return list;
    }

    @Override
    public FoodMenuResponseDto saveFoodMenu(FoodMenuDto foodMenuDto) {
        FoodMenu foodMenu = new FoodMenu();
        foodMenu.setMenuName(foodMenuDto.getMenuName());
        foodMenu.setMenuPrice(foodMenuDto.getMenuPrice());

        FoodCorner customer = new FoodCorner();
        customer.setCornerNum(foodMenuDto.getCornerNum());
        foodMenu.setCornerNum(customer);

        // 외래키의 객체주소는 갖고 오지만 값을 갖고오지 못한다.
        // 그래서 Dto 의  외래키 형을 객체형(Customer) -> Long 으로 바꿔줌
//        customer.setCustomerNum(customer);
//        FoodCorner foodCorner = entityManager.find(FoodCorner.class, foodMenuDto.getCornerNum().getCornerNum());
//        foodMenu.setCornerNum(foodCorner);

        FoodMenu savedFoodMenu = foodMenuDAO.insertFoodMenu(foodMenu);

        FoodMenuResponseDto foodMenuResponseDto = new FoodMenuResponseDto();
        foodMenuResponseDto.setMenuNum(savedFoodMenu.getMenuNum());
        foodMenuResponseDto.setMenuName(savedFoodMenu.getMenuName());
        foodMenuResponseDto.setMenuPrice(savedFoodMenu.getMenuPrice());
        foodMenuResponseDto.setCornerNum(savedFoodMenu.getCornerNum().getCornerNum());

        return foodMenuResponseDto;
    }

    // =======================
    @Override
    public FoodMenuDto saveFoodMenu1(FoodMenuDto foodMenuDto) {
        FoodMenu foodMenu = new FoodMenu();
        foodMenu.setMenuName(foodMenuDto.getMenuName());
        foodMenu.setMenuPrice(foodMenuDto.getMenuPrice());

        FoodCorner customer = new FoodCorner();
        customer.setCornerNum(foodMenuDto.getCornerNum());
        foodMenu.setCornerNum(customer);

        FoodMenu savedFoodMenu = foodMenuDAO.insertFoodMenu(foodMenu);

        FoodMenuDto foodMenuResponseDto = new FoodMenuDto();
        foodMenuResponseDto.setMenuName(savedFoodMenu.getMenuName());
        foodMenuResponseDto.setMenuPrice(savedFoodMenu.getMenuPrice());
        foodMenuResponseDto.setCornerNum(savedFoodMenu.getCornerNum().getCornerNum());

        return foodMenuResponseDto;
    }

    @Override
    public FoodMenuResponseDto updateFoodMenuPrice(Long menuNum, Long menuPrice) throws Exception {
        FoodMenu updateFoodMenu = foodMenuDAO.updateFoodMenuPrice(menuNum, menuPrice);

        FoodMenuResponseDto foodMenuResponseDto = new FoodMenuResponseDto();
        foodMenuResponseDto.setMenuPrice(updateFoodMenu.getMenuPrice());
        return foodMenuResponseDto;
    }

    @Override
    public void deleteFoodMenu(Long menuNum) throws Exception{
        foodMenuDAO.deleteFoodMenu(menuNum);
    }
}
