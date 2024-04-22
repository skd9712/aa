<%--
  Created by IntelliJ IDEA.
  User: skd97
  Date: 2024-04-21
  Time: 오후 9:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<ul>
    <c:set var="dto" value="${requestScope.dto}"/>
    <c:choose>
        <c:when test="${empty dto || empty dto.btitle}">
            <c:out value="자료가 없습니다"/>
        </c:when>
        <c:otherwise>
            <li>번호: ${dto.bno}</li>
            <li>제목: ${dto.btitle}</li>
            <li>내용: ${dto.bcontent}</li>
            <li>이미지:
                <c:forEach var="img" items="${fn:split(dto.bimg,';')}">
                    <img src="upload/${img}" alt="${img}"></li>
                </c:forEach>

            <li>조회수: ${dto.readno}</li>
        </c:otherwise>
    </c:choose>
</ul>
<a href="list.do">목록</a>
</body>
</html>
