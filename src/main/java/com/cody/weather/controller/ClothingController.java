package com.cody.weather.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClothingController {

    @GetMapping("/clothing")
    public String showClothing(Model model) {
        // 의상 추천 로직
        model.addAttribute("outfit", "T-shirt and shorts");
        return "clothing";
    }
}
