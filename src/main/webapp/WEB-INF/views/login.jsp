<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>로그인</title>
</head>
<body>

    <h1>로그인</h1>

    <form action="/user/login" method="post">
        <div>
            <label for="userId">아이디:</label>
            <input type="text" id="userId" name="userId" required>
        </div>
        
        <div>
            <label for="password">비밀번호:</label>
            <input type="password" id="password" name="password" required>
        </div>

        <div>
            <button type="submit">로그인</button>
            <a href="/signup">회원가입</a>
        </div>
    </form>

    <c:if test="${not empty error}">
        <p style="color: red;">${error}</p>
    </c:if>

</body>
</html>
