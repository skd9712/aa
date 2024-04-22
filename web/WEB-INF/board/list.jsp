<%--
  Created by IntelliJ IDEA.
  User: skd97
  Date: 2024-04-21
  Time: 오후 8:38
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
<table>
    <thead>
    <tr>
        <th>번호</th>
        <th>제목</th>
        <th>조회수</th>
    </tr>
    </thead>
    <tbody>
    <c:if test="${empty list}">
        <tr>
            <td>자료없음</td>
        </tr>
    </c:if>
    <c:if test="${!(empty list)}">
        <c:forEach var="item" items="${list}">
            <tr>
                <td><c:out value="${item.bno}"/></td>
                <c:url var="url" value="detail.do">
                    <c:param name="bno" value="${item.bno}"/>
                </c:url>
                <td><a href=${url}><c:out value="${item.btitle}"/></a></td>
                <td><c:out value="${item.readno}"/></td>
            </tr>
        </c:forEach>
    </c:if>
    </tbody>
</table>
<a href="write.do">추가</a>
</body>
</html>
