<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: jhta
  Date: 2024-06-20
  Time: 오후 4:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>detail</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</head>
<body>
    <div class="container">
        <table class="table table-striped">
            <tr>
                <th style="width:160px">writer</th>
                <td>${board.writer}</td>

                <th style="width:160px">regdate</th>
                <td>${board.regdate}</td>
            </tr>
                <th>hits</th>
                <td>${board.hits}</td>

                <th style="width:160px">title</th>
                <td>${board.title}</td>
            </tr>
            <tr>
                <th colspan="4" style="height:400px">contents</th>
                <td>${board.contents}</td>
            </tr>
            <tr>
                <td colspan="4">
                    <a href="board/list" class="btn btn-primary">목록</a>
                    <a href="modify?bno=${board.bno}" class="btn btn-secondary">수정</a>
                    <a href="delete?bno=${board.bno}" class="btn btn-danger">삭제</a>
                </td>
            </tr>
        </table>
    </div>
</body>
</html>
