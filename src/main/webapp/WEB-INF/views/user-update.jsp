<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: sebastian
  Date: 12.02.2021
  Time: 14:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Oddam w dobre ręce</title>
</head>
<body>
<form:form modelAttribute="updateUser" method="post" action="/admin/users/${updateUser.id}">
    <form:input path="email" type="email" value="${updateUser.email}"/>
    <form:input path="username" value="${updateUser.username}"/>
    <form:input path="firstName" value="${updateUser.firstName}"/>
    <form:input path="lastName" value="${updateUser.lastName}"/>
    <button type="submit">Zapisz</button>
</form:form>
<br>
<a href="http://localhost:8080/logout">Wyloguj</a><br>
<a href="http://localhost:8080/admin/home">Głowny panel administratora</a>
</body>
</html>
