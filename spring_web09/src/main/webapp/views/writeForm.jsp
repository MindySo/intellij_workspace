<%--
  Created by IntelliJ IDEA.
  User: jhta
  Date: 2024-06-20
  Time: 오후 3:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>writeForm</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    </head>
    <body>
        <div class="container">
            <h3>writeForm</h3>
            <form action="" method="post">
                <table class="table table-striped">
                    <tr>
                        <th>writer</th>
                        <td><input type="text" name="writer"></td>
                    </tr>
                        <th>title</th>
                        <td><input type="text" name="title"></td>
                    </tr>
                    <tr>
                        <th>contents</th>
                        <td><textarea name="contents" cols="30" rows="10"></textarea></td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <input type="submit" class="btn btn-primary" value="쓰기">
                            <input type="reset" class="btn btn-warning" value="RESET">
                            <a href="board/list" class="btn btn-secondary">목록</a>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </body>
</html>
