<%--
  Created by IntelliJ IDEA.
  User: jhta
  Date: 2024-06-18
  Time: 오후 3:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>selectMenu</title>
</head>
<body>
    <h3>Selected Menu</h3>

    <c:forEach var="menu" items="${menuList}">
        <li>${menu}</li>
    </c:forEach>

</body>
</html>
