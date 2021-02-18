<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: sebastian
  Date: 11.02.2021
  Time: 14:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Oddam w dobre ręce</title>
</head>
<body>
<form:form action="/admin/institutions/${update.id}" method="post" modelAttribute="update">
    Nazwa instytucji: <form:input path="name" value="${update.name}"/><br>
    Opis instytucji: <form:input path="description" value="${update.description}"/><br>
    <button type="submit">Zapisz</button>

</form:form>
<br>
<a href="http://localhost:8080/logout">Wyloguj</a><br>
<a href="http://localhost:8080/admin/home">Głowny panel administratora</a>
</body>
</html>
