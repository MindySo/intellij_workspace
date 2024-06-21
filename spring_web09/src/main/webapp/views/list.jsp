<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: jhta
  Date: 2024-06-20
  Time: 오후 2:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>list.jsp</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</head>
<body>
    <div class="container" style="padding: 30px">
        <h3>list.jsp</h3>
        <h4>총 게시물 수 : ${map.totalNumber}</h4>
        <h4>페이지 당 게시물 수 : ${map.countPerPage}</h4>
        <h4>총 페이지 수 : ${map.totalPages}</h4>
        <h4>현재 페이지 시작번호 : ${map.startNo}</h4>
        <h4>현재 페이지 끝번호 : ${map.endNo}</h4>
        <h4>currentPage : ${map.currentPage}</h4>
        <h4>startPageNo : ${map.startPageNo}</h4>
        <h4>endPageNo : ${map.endPageNo}</h4>
        <h4>prev : ${map.prev}</h4>
        <h4>next : ${map.next}</h4>


        <a type="button" class="btn btn-primary" href="write">글쓰기</a>

        <table class="table table-striped">
            <tr>
                <th>bno</th>
                <th>writer</th>
                <th>title</th>
                <th>contents</th>
                <th>regdate</th>
                <th>hits</th>
                <th>status</th>
            </tr>
            <c:forEach var="board" items="${list}">
                <tr>
                    <td>${board.bno}</td>
                    <td>${board.writer}</td>
                    <td><a href="detail?bno=${board.bno}">${board.title}</a></td>
                    <td>${board.contents}</td>
                    <td>${board.regdate}</td>
                    <td>${board.hits}</td>
                    <td>${board.status}</td>
                </tr>
            </c:forEach>
        </table>
        <div style="text-align: center">
            <nav aria-label="Page navigation example">
                <ul class="pagination">
                    <c:if test="${map.prev}">
                        <li class="page-item"><a class="page-link" href="list?currentPage=${map.currentPage-1}"><<</a></li>
                    </c:if>
                    <c:forEach var="i" begin="${map.startPageNo}" end="${map.endPageNo}">
                        <li class="page-item"><a class="page-link" href="list?currentPage=${i}">${i}</a></li>
                    </c:forEach>
<%--                    <c:if test="${map.next}">--%>
                        <li class="page-item"><a class="page-link" href="list?currentPage=${map.currentPage+1}">>></a></li>
<%--                    </c:if>--%>
                </ul>
            </nav>
        </div>
    </div>
</body>
</html>
