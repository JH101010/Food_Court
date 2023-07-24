package com.foodcourt.final1912074.controller;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller // jsp, thymeleaf로 응답함
@RequestMapping("/index")
public class MainController {
    @PersistenceContext
    EntityManager entityManager;


    @GetMapping()
    public String index() {
        return "index";
    }


    @GetMapping("/plus")
    public String plus() {
        return "plus";
    }

    @GetMapping("/wait")
    public String wait2() {
        return "wait";
    }

    @GetMapping("/cart")
    public String cart() {
        return "cart";
    }
}
