package com.foodcourt.final1912074;

import com.foodcourt.final1912074.data.dao.FoodMenuDAO;
import com.foodcourt.final1912074.data.dto.FoodMenuDto;
import com.foodcourt.final1912074.data.entity.FoodCorner;
import com.foodcourt.final1912074.data.entity.FoodMenu;
import com.foodcourt.final1912074.data.repository.FoodCornerRepository;
import com.foodcourt.final1912074.data.repository.FoodMenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

@Component
public class DataLoader implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        init();
    }
    @Autowired
    FoodMenuRepository foodMenuRepository;
    @Autowired
    FoodCornerRepository foodCornerRepository;

    private String[] cornerName = new String[]{
            "한식", "중식", "일식", "양식"
    };

    private String[] menuName = new String[]{
            "파전", "불고기", "짜장면", "탕수육",
            "미소라면", "고기라면", "봉골레파스타", "고르곤졸라피자"
    };

    private Long[] menuPrice = new Long[]{
            2000L, 8000L, 5000L, 8000L,
            7000L, 7000L, 8000L, 6000L
    };

    private void init() {
        // 푸드코너 기본값
        Long number = 1L;
        Queue<FoodCorner> queue = new LinkedList();

        FoodCorner foodCorner;
        for(int i = 0; i < cornerName.length; i++){
            foodCorner = new FoodCorner();
            foodCorner.setCornerNum(number++);
            foodCorner.setCornerName(cornerName[i]);
            queue.add(foodCorner);
        }
        foodCornerRepository.saveAll(queue);

        // 메뉴 기본값
        number = 1L;
        FoodMenu foodMenu;
        Queue<FoodMenu> queue2 = new LinkedList();

        foodCorner = new FoodCorner();
        foodCorner.setCornerNum(1L);
        for(int i = 0; i < 2; i++) {
            foodMenu = new FoodMenu();
            foodMenu.setMenuNum(number++);
            foodMenu.setMenuName(menuName[i]);
            foodMenu.setMenuPrice(menuPrice[i]);
            foodMenu.setCornerNum(foodCorner);
            queue2.add(foodMenu);
        }
        foodMenuRepository.saveAll(queue2);
        queue2.clear();

        foodCorner = new FoodCorner();
        foodCorner.setCornerNum(2L);
        for(int i = 2; i < 4; i++) {
            foodMenu = new FoodMenu();
            foodMenu.setMenuNum(number++);
            foodMenu.setMenuName(menuName[i]);
            foodMenu.setMenuPrice(menuPrice[i]);
            foodMenu.setCornerNum(foodCorner);
            queue2.add(foodMenu);
        }
        foodMenuRepository.saveAll(queue2);
        queue2.clear();

        foodCorner = new FoodCorner();
        foodCorner.setCornerNum(3L);
        for(int i = 4; i < 6; i++) {
            foodMenu = new FoodMenu();
            foodMenu.setMenuNum(number++);
            foodMenu.setMenuName(menuName[i]);
            foodMenu.setMenuPrice(menuPrice[i]);
            foodMenu.setCornerNum(foodCorner);
            queue2.add(foodMenu);
        }
        foodMenuRepository.saveAll(queue2);
        queue2.clear();

        foodCorner = new FoodCorner();
        foodCorner.setCornerNum(4L);
        for(int i = 6; i < menuName.length; i++) {
            foodMenu = new FoodMenu();
            foodMenu.setMenuNum(number++);
            foodMenu.setMenuName(menuName[i]);
            foodMenu.setMenuPrice(menuPrice[i]);
            foodMenu.setCornerNum(foodCorner);
            queue2.add(foodMenu);
        }
        foodMenuRepository.saveAll(queue2);
    }
}
