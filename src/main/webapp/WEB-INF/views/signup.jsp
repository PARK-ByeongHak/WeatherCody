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
            // AJAX를 사용하여 서버에 중복 확인 요청
            // 중복 시 메시지를 출력
            // 중복이 아닌 경우 "사용 가능한 아이디입니다." 메시지 출력
        }

        function validateForm() {
            // 각 입력 필드에 대한 유효성 검사 수행
            // 유효하지 않은 경우 메시지를 출력하고 false 반환
            // 모두 유효한 경우 true 반환
        }
        
        function validatePassword(password) {
            // 영어와 숫자를 포함하고, 최소 10자 이상인지 확인
            var regex = /^(?=.*[A-Za-z])(?=.*\d).{10,}$/;
            return regex.test(password);
        }
    </script>
</body>
</html>