<%--
  Created by IntelliJ IDEA.
  User: jhta
  Date: 2024-06-18
  Time: 오후 2:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>menu</title>
</head>
<body>
    <h3>select menu</h3>
    <form action="selectMenu.do">
        <input type="checkbox" name="ck" value="menu1">메뉴1
        <input type="checkbox" name="ck" value="menu2">메뉴2
        <input type="checkbox" name="ck" value="menu3">메뉴3
        <input type="checkbox" name="ck" value="menu4">메뉴4
        <input type="checkbox" name="ck" value="menu5">메뉴5
        <br>
        <input type="submit" value="확인">
    </form>
</body>
</html>
