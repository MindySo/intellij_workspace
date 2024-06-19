<%--
  Created by IntelliJ IDEA.
  User: jhta
  Date: 2024-06-19
  Time: 오전 11:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Main</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</head>
<body>
    <div class="container">

        <h3>Main</h3>
        <img src="./th.jpeg" alt="">

        <%-- JSTL을 사용해서 id가 존재하면 XXX님 환영합니다 --%>

        <h3>${id}</h3>

        <c:if test="${id != null}">
            <h2>${id}님 환영합니다</h2>
            <a href="logout.do">로그아웃</a>
            <a href="showDept.do">부서목록보기</a>
        </c:if>
        <c:if test="${empty id}">
            <ul>
                <li><a href="login.do">로그인</a></li>
                <li><a href="join.do">회원가입</a></li>
            </ul>
        </c:if>
    </div>
</body>
</html>
