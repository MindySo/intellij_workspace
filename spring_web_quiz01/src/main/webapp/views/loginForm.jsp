<%--
  Created by IntelliJ IDEA.
  User: jhta
  Date: 2024-06-19
  Time: 오전 11:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>loginForm.jsp</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</head>
<body>
<form action="login.do" method="post">
    <table class="table">
        <tr>
            <th>ID</th>
            <td>
                <input type="text" name="id">
            </td>
        </tr>
        <tr>
            <th>PW</th>
            <td>
                <input type="text" name="pw">
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input class="btn btn-primary" type="submit" value="로그인">
                <input class="btn btn-secondary" type="button" value="가입하기">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
