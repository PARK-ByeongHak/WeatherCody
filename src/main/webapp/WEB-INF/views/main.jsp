<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Weather Cody - 지금 날씨에 딱 맞는 코디 추천</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
            text-align: center;
        }

        #weather-container {
            margin-top: 20px;
        }

        #outfit-recommendation {
            margin-top: 20px;
        }
    </style>
</head>
<body>

    <h1>Weather Cody - 지금 날씨에 딱 맞는 코디 추천</h1>

    <!-- 주소 검색 상자 -->
    <input type="text" id="location-input" placeholder="주소를 입력하세요">
    <button onclick="searchWeather()">날씨 검색</button>

    <!-- 날씨 표시 -->
    <div id="weather-container"></div>

    <!-- 날씨에 맞는 코디 추천 -->
    <div id="outfit-recommendation"></div>

    <script>
        function searchWeather() {
            // 여기에 날씨 API 호출 및 응답 처리 로직 구현
            // API 호출 결과를 사용하여 날씨 정보를 표시 코디 추천
        }
    </script>

</body>
</html>
