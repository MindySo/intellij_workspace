<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: jhta
  Date: 2024-06-20
  Time: 오전 11:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>filelist.jsp</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</head>
<body>
    <h3>filelist.jsp</h3>
    <table class="table table-striped">
        <tr>
            <th>no</th>
            <th>filepath</th>
            <th>img</th>
        </tr>
        <c:forEach var="file" items="${list}">
                <tr>
                    <td>${file.no}</td>
                    <td><a href="download?no=${file.no}">${file.filePath}</a></td>
                    <td><img src="./data/${file.filePath}" alt=""></td>
                </tr>
        </c:forEach>
    </table>

</body>
</html>
