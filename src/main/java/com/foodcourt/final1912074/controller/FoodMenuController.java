package com.foodcourt.final1912074.controller;

import com.foodcourt.final1912074.data.dto.FoodMenuDto;
import com.foodcourt.final1912074.data.dto.FoodMenuResponseDto;
import com.foodcourt.final1912074.data.entity.*;
import com.foodcourt.final1912074.service.FoodMenuService;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequestMapping("/foodMenu")
public class FoodMenuController {
    private final FoodMenuService foodMenuService;
    @Autowired
    public FoodMenuController(FoodMenuService foodMenuService) {
        this.foodMenuService = foodMenuService;
    }
    @PersistenceContext
    EntityManager entityManager;

    // 후보키 빼고 전체 조회
    @GetMapping("/getAll")
    public ResponseEntity<List<FoodMenu>> getAllFoodMenu() {
        List<FoodMenu> lists = foodMenuService.getAllMenu();
        return ResponseEntity.status(HttpStatus.OK).body(lists);
    }

    // 이름으로 조회
    @GetMapping("/getCornerNum") // ..../getCornerNum?cornerNum=2
    public String getCornerNum(Model model, Long cornerNum, String value) {
        JPAQueryFactory jpaQueryFactory = new JPAQueryFactory(entityManager);
        QFoodMenu qFoodMenu = QFoodMenu.foodMenu;

        List<FoodMenu> foodMenuList = jpaQueryFactory
                .selectFrom(qFoodMenu)
                .where(qFoodMenu.cornerNum.cornerNum.eq(cornerNum))
                .fetch();
        model.addAttribute("foodMenuList",foodMenuList);
        String val = value;
        return val;
    }

    // 메뉴추가
//    @PostMapping("/save") //cornerNum 이 없는 코너일 시 NULL
//    public ResponseEntity<FoodMenuResponseDto> saveFoodMenu(@RequestBody FoodMenuDto foodMenuDto) {
//        FoodMenuResponseDto foodMenuResponseDto = foodMenuService.saveFoodMenu(foodMenuDto);
//        return ResponseEntity.status(HttpStatus.OK).body(foodMenuResponseDto);
//    }
    @PostMapping("/save") //cornerNum 이 없는 코너일 시 NULL
    public String saveFoodMenu(FoodMenuDto foodMenuDto){
        try {
            FoodMenuDto foodMenuDto1 = foodMenuService.saveFoodMenu1(foodMenuDto);
        }catch (Exception e) {
            System.out.println(e + "====오류발생====");
        }
        return "plus";
    }

    // 삭제
    /*@DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteFoodMenu(@PathVariable Long id) throws Exception {
        foodMenuService.deleteFoodMenu(id);
        return ResponseEntity.status(HttpStatus.OK).body(id + "번 정상 삭제완료..");
    }*/
    @GetMapping("/delete/{menuNum}")
    public String deleteFoodMenu(@PathVariable("menuNum") Long id) throws Exception {
        foodMenuService.deleteFoodMenu(id);
        return "index";
    }

    // 수정
    @PutMapping("/input")
    public ResponseEntity<FoodMenuResponseDto> updateFoodMenuPrice(@RequestBody FoodMenuResponseDto foodMenuResponseDto) throws Exception {
        FoodMenuResponseDto responseDto = foodMenuService.updateFoodMenuPrice(
                foodMenuResponseDto.getMenuNum(), foodMenuResponseDto.getMenuPrice());
        return ResponseEntity.status(HttpStatus.OK).body(responseDto);
    }
}
