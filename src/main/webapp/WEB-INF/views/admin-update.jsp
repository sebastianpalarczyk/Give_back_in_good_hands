<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: sebastian
  Date: 11.02.2021
  Time: 16:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="post" modelAttribute="updateAdmin" action="/admin/admins/${updateAdmin.id}">
    Email: <form:input path="email" type="email" value="${updateAdmin.email}"/>
    Username: <form:input path="username" value="${updateAdmin.username}"/>
    Imię: <form:input path="firstName" value="${updateAdmin.firstName}"/>
    Nazwisko: <form:input path="lastName" value="${updateAdmin.lastName}"/>
    <button type="submit">Zapisz</button>
</form:form>
<br>
<a href="http://localhost:8080/logout">Wyloguj</a><br>
<a href="http://localhost:8080/admin/home">Głowny panel administratora</a>

</body>
</html>
