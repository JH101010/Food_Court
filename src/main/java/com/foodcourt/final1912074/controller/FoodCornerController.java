package com.foodcourt.final1912074.controller;

import com.foodcourt.final1912074.data.dto.FoodCornerDto;
import com.foodcourt.final1912074.data.dto.FoodCornerResponseDto;
import com.foodcourt.final1912074.data.entity.FoodCorner;
import com.foodcourt.final1912074.service.FoodCornerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/foodCorner")
public class FoodCornerController {

    private final FoodCornerService foodCornerService;

    @Autowired
    public FoodCornerController(FoodCornerService foodCornerService) {
        this.foodCornerService = foodCornerService;
    }

    // 전체조회
    @GetMapping("/getAll")
    public ResponseEntity<List<FoodCorner>> getAllFoodCorner() {
        List<FoodCorner> lists = foodCornerService.getAllFoodCorner();
        return ResponseEntity.status(HttpStatus.OK).body(lists);
    }

    // 코너추가
    @PostMapping("/save")
    public ResponseEntity<FoodCornerResponseDto> createFoodCorner(@RequestBody FoodCornerDto foodCornerDto) {
        FoodCornerResponseDto foodCornerResponseDto = foodCornerService.saveFoodCorner(foodCornerDto);
        return ResponseEntity.status(HttpStatus.OK).body(foodCornerResponseDto);
    }
    // 코너삭제
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteFoodCorner(@PathVariable Long id) throws Exception {
        foodCornerService.deleteFoodCorner(id);
        return ResponseEntity.status(HttpStatus.OK).body(id + "번 정상 삭제완료..");
    }
}
