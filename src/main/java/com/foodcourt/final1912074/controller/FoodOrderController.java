package com.foodcourt.final1912074.controller;

import com.foodcourt.final1912074.data.dto.FoodOrderDto;
import com.foodcourt.final1912074.data.dto.FoodOrderResponseDto;
import com.foodcourt.final1912074.data.entity.FoodOrder;
import com.foodcourt.final1912074.data.entity.QFoodOrder;
import com.foodcourt.final1912074.service.FoodOrderService;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/foodOrder")
public class FoodOrderController {
    private final FoodOrderService foodOrderService;

    @Autowired
    public FoodOrderController(FoodOrderService foodOrderService) {
        this.foodOrderService = foodOrderService;
    }

    @PersistenceContext
    EntityManager entityManager;

    // 전체 조회
    @GetMapping("/getAll")
    public String getAllFoodOrder(Model model) {
        List<FoodOrder> lists = foodOrderService.getAllOrder();
        model.addAttribute("orderList", lists);
        return "cart";
    }

    // 고객 id로 조회
    @GetMapping("/getCustomer") // ..../getCustomer?cornerNum=2
    public String getCustomer(Model model, HttpSession session) {
        Long cid;
        if(session.getAttribute("cId") == "" || session.getAttribute("cId") == null){
            cid = 0L;
        }else {
            cid = (Long) session.getAttribute("cId");
        }
        JPAQueryFactory jpaQueryFactory = new JPAQueryFactory(entityManager);
        QFoodOrder qFoodOrder = QFoodOrder.foodOrder;

        List<FoodOrder> foodOrderList = jpaQueryFactory
                .selectFrom(qFoodOrder)
                .where(qFoodOrder.customerNum.customerNum.eq(cid))
                .fetch();
        model.addAttribute("orderList", foodOrderList);
        return "cart";
    }

    @GetMapping("/getCustomerS/{customerNum}") // ..../getCustomer?cornerNum=2
    public String getCustomerS(Model model, @PathVariable("customerNum") Long customerNum) {
        JPAQueryFactory jpaQueryFactory = new JPAQueryFactory(entityManager);
        QFoodOrder qFoodOrder = QFoodOrder.foodOrder;

        List<FoodOrder> foodOrderList = jpaQueryFactory
                .selectFrom(qFoodOrder)
                .where(qFoodOrder.customerNum.customerNum.eq(customerNum))
                .fetch();
        model.addAttribute("orderList", foodOrderList);
        return "cart";
    }

    // 주문목록 추가
    @PostMapping("/save") // 참조한 테이블에 없는 값일 시 NULL
    public String saveFoodOrder(FoodOrderDto foodOrderDto, HttpSession session, @RequestParam("selectedMenuName") String menuName,
                                @RequestParam("selectedMenuPrice") String menuPrice,  @RequestParam("selectedMenuNum") String menuNum) {
        Long cid = (Long) session.getAttribute("cId");
        String name = menuName.replaceAll(",", "");
        Long price = Long.valueOf(menuPrice.replaceAll(",", ""));
        Long mNum = Long.valueOf(menuNum.replaceAll(",", ""));

        foodOrderDto.setCustomerNum(cid);
        foodOrderDto.setMenuName(name);
        foodOrderDto.setMenuNum(mNum);
        foodOrderDto.setMenuPrice(price);

        System.out.println("customerNum: " + foodOrderDto.getCustomerNum());
        System.out.println("menuName: " + foodOrderDto.getMenuName());
        System.out.println("menuPrice: " + foodOrderDto.getMenuPrice());
        System.out.println("menuNum: " + foodOrderDto.getMenuNum());
        FoodOrderResponseDto foodOrderResponseDto = foodOrderService.saveFoodOrder(foodOrderDto);
        return "index";
    }

    // 삭제
    @GetMapping("/delete/{orderId}")
    public String deleteOrder(@PathVariable("orderId") Long id) throws Exception {
        foodOrderService.deleteFoodOrder(id);
        return "index";
    }

}
