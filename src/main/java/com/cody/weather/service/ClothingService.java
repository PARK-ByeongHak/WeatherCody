package com.cody.weather.service;

import org.springframework.stereotype.Service;

@Service
public class ClothingService {

    public String recommendOutfit() {
        // 실제로는 날씨 정보를 기반으로 의상을 추천하는 로직을 추가할 수 있습니다.
        return "T-shirt and shorts";
    }
}
