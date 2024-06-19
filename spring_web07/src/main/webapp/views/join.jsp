<%--
  Created by IntelliJ IDEA.
  User: jhta
  Date: 2024-06-19
  Time: 오후 12:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JOIN 페이지입니다</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</head>
<body>
    <div class="container">
        <form action="join.do" method="post">
            <div><span>아이디 : <input type="text" name="id"></span></div>
            <div><span>이름 : <input type="text" name="name"></span></div>
            <div><span>비밀번호 : <input type="text" name="pw"></span></div>
            <div><span>이메일 : <input type="text" name="email"></span></div>
            <div><span>가입동기 : <input type="text" name="motive"></span></div>
            <div>
                <input class="btn btn-primary" type="submit" value="회원가입">
                <input class="btn btn-secondary" type="button" value="취소">
            </div>
        </form>
    </div>
</body>
</html>
