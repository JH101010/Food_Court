package com.foodcourt.final1912074.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller // jsp, thymeleaf로 응답함
@RequestMapping("/login")
public class LoginController {
    @PostMapping()
    public String login(@RequestParam("id") String id, @RequestParam("pw") String pw, HttpSession session) {
        if (id.equals("admin") && pw.equals("1234")) {
            session.setAttribute("loginTag", "YES"); // 로그인 성공 표시
        } else {
            // 세션에 저장된 정보 없이 다시 화면에 가기 위함.
            session.setAttribute("loginTag", "No");
        }
        return "index";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("loginTag", "No");
        return "index";
    }
}
