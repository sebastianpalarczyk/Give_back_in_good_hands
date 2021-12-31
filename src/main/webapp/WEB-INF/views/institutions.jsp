<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: sebastian
  Date: 11.02.2021
  Time: 13:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach var="element" items="${allInstitutions}">
    <c:out value="${element.name}"/>
    <a href="http://localhost:8080/admin/institutions/${element.id}">Edytuj</a><br>
    <a href="http://localhost:8080/admin/institutions/delete/${element.id}">Usuń</a><br>
</c:forEach>
<br>
<a href="http://localhost:8080/logout">Wyloguj</a><br>
<a href="http://localhost:8080/admin/home">Głowny panel administratora</a>
</body>
</html>
