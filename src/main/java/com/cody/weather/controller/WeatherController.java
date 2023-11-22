package com.cody.weather.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WeatherController {

    @GetMapping("/weather")
    public String showWeather(Model model) {
        // 날씨 정보 로직
        model.addAttribute("temperature", "25°C");
        model.addAttribute("condition", "Sunny");
        return "weather";
    }
}