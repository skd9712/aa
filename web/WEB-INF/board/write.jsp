<%--
  Created by IntelliJ IDEA.
  User: skd97
  Date: 2024-04-21
  Time: 오후 9:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="write_result.do" enctype="multipart/form-data">
    <ul>
        <li>
            <label for="title">제목</label>
            <input type="text" name="title" id="title">
        </li>
        <li>
            <label for="content">내용</label>
            <input type="text" name="content" id="content">
        </li>
        <li>
            <label>이미지</label>
            <input type="file" name="imgfile" id="imgfile">
            <label>이미지</label>
            <input type="file" name="imgfile2">
            <input type="file" name="imgfile3">
        </li>
        <li>
            <button id="btn" type="submit">완료</button>
            <button id="btn2" type="reset">취소</button>
        </li>
    </ul>
</form>
</body>
</html>
