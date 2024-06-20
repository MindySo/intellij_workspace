<%--
  Created by IntelliJ IDEA.
  User: jhta
  Date: 2024-06-19
  Time: 오후 5:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>uploadForm.jsp</title>
</head>
<body>
    <h3>uploadForm.jsp</h3>
    <form action="uploadOk.do" method="post" enctype="multipart/form-data">
        <input type="text" name="msg" id="">

        <h5>파일 다중선택 가능</h5>
        <input type="file" name="uploadfile" multiple>

        <%--
        <h5>파일 한개씩 선택</h5>
        <input type="file" name="uploadfile">
        --%>

        <input type="submit" value="전송">
    </form>
</body>
</html>
