package com.cody.weather.service;

import org.springframework.stereotype.Service;

@Service
public class WeatherService {

    public String getTemperature() {
        // 실제로는 OpenWeatherMap API를 통해 날씨 정보를 가져오는 로직을 추가할 수 있습니다.
        return "25°C";
    }

    public String getCondition() {
        // 실제로는 OpenWeatherMap API를 통해 날씨 정보를 가져오는 로직을 추가할 수 있습니다.
        return "Sunny";
    }
}
