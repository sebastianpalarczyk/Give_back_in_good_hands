<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: sebastian
  Date: 11.02.2021
  Time: 16:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Oddam w dobre ręce</title>
</head>
<body>
<c:forEach var="element" items="${users}">
    <c:out value="${element.id}"/>
    <c:out value="${element.firstName}"/>
    <c:out value="${element.lastName}"/>
    <a href="http://localhost:8080/admin/users/${element.id}">Edytuj</a>
    <a href="http://localhost:8080/admin/users/delete/${element.id}">Usuń</a><br>
</c:forEach>
<br>
<a href="http://localhost:8080/logout">Wyloguj</a><br>
<a href="http://localhost:8080/admin/home">Głowny panel administratora</a>

</body>
</html>

