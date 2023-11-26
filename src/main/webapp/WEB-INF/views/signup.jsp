<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>회원 가입</title>
</head>
<body>
    <h1>회원가입</h1>

    <form action="/user/signup" method="post">
        <label>아이디:</label>
        <input type="text" name="userId" required>
        <button type="button" onclick="checkDuplicate()">아이디 확인</button><br>

        <label>비밀번호:</label>
        <input type="password" name="password" required><br>

        <label>비밀번호 확인:</label>
        <input type="password" name="confirmPassword" required><br>

        <label>이름:</label>
        <input type="text" name="name" required><br>

        <label>생년월일:</label>
        <input type="date" name="birthdate" required><br>

        <label>성별:</label>
        <input type="radio" name="gender" value="남성" required>남성
        <input type="radio" name="gender" value="여성" required>여성
        <input type="radio" name="gender" value="기타" required>기타<br>

        <label>주소:</label>
        <input type="text" name="address" required><br>

        <button type="submit" onclick="return validateForm()">회원가입</button>
    </form>

    <p id="message"></p>

    <script>
	    function checkDuplicate() {
	        var userId = document.getElementsByName("userId")[0].value;
	
	        // AJAX 요청을 위한 XMLHttpRequest 객체 생성
	        var xhr = new XMLHttpRequest();
	
	        // 서버로 요청을 보낼 메소드와 URL 설정
	        xhr.open("GET", "/user/checkDuplicate?userId=" + userId, true);
	
	        // 요청이 완료되면 실행되는 콜백 함수
	        xhr.onreadystatechange = function () {
	            if (xhr.readyState == 4 && xhr.status == 200) {
	                // 서버에서 반환한 응답 데이터 가져오기
	                var response = xhr.responseText;
	
	                // 메시지를 출력할 요소 가져오기
	                var messageElement = document.getElementById("message");
	
	                // 중복 여부에 따라 메시지 설정
	                if (response === "true") {
	                    messageElement.innerHTML = "이미 사용 중인 아이디입니다.";
	                } else {
	                    messageElement.innerHTML = "사용 가능한 아이디입니다.";
	                }
	            }
	        };
	
	        // 요청 전송
	        xhr.send();
	    }
	
	    function validateForm() {
	        // 비밀번호 유효성 검사
	        var password = document.getElementsByName("password")[0].value;
	        if (!validatePassword(password)) {
	            alert("비밀번호는 영문과 숫자를 포함하고, 최소 10자 이상이어야 합니다.");
	            return false;
	        }
	
	        // 비밀번호 확인 일치 여부 확인
	        var confirmPassword = document.getElementsByName("confirmPassword")[0].value;
	        if (password !== confirmPassword) {
	            alert("비밀번호와 비밀번호 확인이 일치하지 않습니다.");
	            return false;
	        }
	
	        // 이름 특수문자 확인
	        var name = document.getElementsByName("name")[0].value;
	        var nameRegex = /^[가-힣a-zA-Z\s]+$/; // 한글, 영문, 공백 허용
	        if (!nameRegex.test(name)) {
	            alert("이름에는 특수문자를 제외한 한글, 영문, 공백만 입력 가능합니다.");
	            return false;
	        }
	
	        // 성별 체크 확인
	        var genderChecked = false;
	        var genderRadios = document.getElementsByName("gender");
	        for (var i = 0; i < genderRadios.length; i++) {
	            if (genderRadios[i].checked) {
	                genderChecked = true;
	                break;
	            }
	        }
	        if (!genderChecked) {
	            alert("성별을 선택해주세요.");
	            return false;
	        }
			
	        // 주소는 api 사용하여 입력 받을 예정.
	        
	        // 모든 조건을 통과하면 true 반환
	        return true;
	    }
	
	    // 비밀번호 유효성 검사 함수
	    function validatePassword(password) {
	        // 영문과 숫자를 포함하고, 최소 10자 이상인지 확인
	        var regex = /^(?=.*[A-Za-z])(?=.*\d).{10,}$/;
	        return regex.test(password);
	    }

    </script>
</body>
</html>