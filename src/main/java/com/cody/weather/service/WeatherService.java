package com.cody.weather.service;

import org.springframework.stereotype.Service;

@Service
public class WeatherService {

    public String getTemperature() {
        
        return "25°C";
    }

    public String getCondition() {
        
        return "Sunny";
    }
}
