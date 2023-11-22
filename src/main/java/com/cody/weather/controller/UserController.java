package com.cody.weather.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @GetMapping("/signup")
    public String showSignupForm() {
        return "signup";
    }

    @GetMapping("/user/profile")
    public String showUserProfile() {
        // 회원 정보 및 주소 로직
        return "userProfile";
    }
}