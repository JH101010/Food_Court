package com.foodcourt.final1912074.controller;

import com.foodcourt.final1912074.data.entity.FoodCorner;
import com.foodcourt.final1912074.data.entity.FoodMenu;
import com.foodcourt.final1912074.data.repository.FoodCornerRepository;
import com.foodcourt.final1912074.data.repository.FoodMenuRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/default")
public class DefaultController {
    @Autowired
    FoodCornerRepository foodCornerRepository;

    @Autowired
    FoodMenuRepository foodMenuRepository;

    @PersistenceContext
    EntityManager entityManager;

    @PostMapping()
    public void saveMany(){
        saveCorner();
        saveMenu();
    }

    // 코너 기본값
    public String saveCorner() {
        FoodCorner foodCorner = new FoodCorner();
        foodCorner.setCornerName("korean");
        foodCornerRepository.save(foodCorner);

        foodCorner = new FoodCorner();
        foodCorner.setCornerName("Chinese");
        foodCornerRepository.save(foodCorner);

        foodCorner = new FoodCorner();
        foodCorner.setCornerName("Japanese");
        foodCornerRepository.save(foodCorner);

        foodCorner = new FoodCorner();
        foodCorner.setCornerName("Western");
        foodCornerRepository.save(foodCorner);

        return "메뉴코너 기본값 저장.";
    }
    // 메뉴 기본값
    public String saveMenu() {
        FoodMenu foodMenu = new FoodMenu();
        foodMenu.setMenuName("Kimchi soup");
        foodMenu.setMenuPrice(8500L);
        FoodCorner foodCorner = entityManager.find(FoodCorner.class, 1);
        foodMenu.setCornerNum(foodCorner);
        foodMenuRepository.save(foodMenu);

        foodMenu = new FoodMenu();
        foodMenu.setMenuName("Pajeon");
        foodMenu.setMenuPrice(1500L);
        foodCorner = entityManager.find(FoodCorner.class, 1);
        foodMenu.setCornerNum(foodCorner);
        foodMenuRepository.save(foodMenu);

        foodMenu = new FoodMenu();
        foodMenu.setMenuName("Bulgogi");
        foodMenu.setMenuPrice(1500L);
        foodCorner = entityManager.find(FoodCorner.class, 1);
        foodMenu.setCornerNum(foodCorner);
        foodMenuRepository.save(foodMenu);

        foodMenu = new FoodMenu();
        foodMenu.setMenuName("Jajangmyeon");
        foodMenu.setMenuPrice(5500L);
        foodCorner = entityManager.find(FoodCorner.class, 2);
        foodMenu.setCornerNum(foodCorner);
        foodMenuRepository.save(foodMenu);

        foodMenu = new FoodMenu();
        foodMenu.setMenuName("SweetAndSourPork");
        foodMenu.setMenuPrice(8500L);
        foodCorner = entityManager.find(FoodCorner.class, 2);
        foodMenu.setCornerNum(foodCorner);
        foodMenuRepository.save(foodMenu);

        foodMenu = new FoodMenu();
        foodMenu.setMenuName("ChiliJapchae");
        foodMenu.setMenuPrice(18000L);
        foodCorner = entityManager.find(FoodCorner.class, 2);
        foodMenu.setCornerNum(foodCorner);
        foodMenuRepository.save(foodMenu);

        foodMenu = new FoodMenu();
        foodMenu.setMenuName("AssortedSushi");
        foodMenu.setMenuPrice(28000L);
        foodCorner = entityManager.find(FoodCorner.class, 3);
        foodMenu.setCornerNum(foodCorner);
        foodMenuRepository.save(foodMenu);

        foodMenu = new FoodMenu();
        foodMenu.setMenuName("Ramen");
        foodMenu.setMenuPrice(6500L);
        foodCorner = entityManager.find(FoodCorner.class, 3);
        foodMenu.setCornerNum(foodCorner);
        foodMenuRepository.save(foodMenu);

        foodMenu = new FoodMenu();
        foodMenu.setMenuName("Sukiyaki");
        foodMenu.setMenuPrice(30000L);
        foodCorner = entityManager.find(FoodCorner.class, 3);
        foodMenu.setCornerNum(foodCorner);
        foodMenuRepository.save(foodMenu);

        foodMenu = new FoodMenu();
        foodMenu.setMenuName("Steak");
        foodMenu.setMenuPrice(50000L);
        foodCorner = entityManager.find(FoodCorner.class, 4);
        foodMenu.setCornerNum(foodCorner);
        foodMenuRepository.save(foodMenu);

        foodMenu = new FoodMenu();
        foodMenu.setMenuName("Pasta");
        foodMenu.setMenuPrice(9000L);
        foodCorner = entityManager.find(FoodCorner.class, 4);
        foodMenu.setCornerNum(foodCorner);
        foodMenuRepository.save(foodMenu);

        foodMenu = new FoodMenu();
        foodMenu.setMenuName("Hamburger");
        foodMenu.setMenuPrice(7000L);
        foodCorner = entityManager.find(FoodCorner.class, 4);
        foodMenu.setCornerNum(foodCorner);
        foodMenuRepository.save(foodMenu);

        return "메뉴 기본값 저장";
    }
}
