<%--
  Created by IntelliJ IDEA.
  User: bianlifeng
  Date: 2019-07-10
  Time: 21:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>商品列表</title>
</head>
<body>
<table border="1">
<c:forEach items = "${item}" var = "it">
    <tr>
        <td>${it.itemname}</td>
        <td>${it.price}</td>
        <td>${it.detail }</td>
        <td><a href="${pageContext.request.contextPath}/itemEdit?id=${it.id}">gengx</a> </td>
    </tr>
</c:forEach>


</table>
</body>
</html>
