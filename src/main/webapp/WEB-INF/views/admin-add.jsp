<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: sebastian
  Date: 11.02.2021
  Time: 15:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Oddam w dobre ręce</title>
</head>
<body>
<form:form method="post" modelAttribute="admin" action="/admin/add">
    Email: <form:input path="email" type="email"/>
    Username: <form:input path="username"/>
    Imię: <form:input path="firstName"/>
    Nazwisko: <form:input path="lastName"/>
    Hasło: <form:input path="password" type="password"/>
    <button type="submit">Zapisz</button>
</form:form>
<br>
<a href="http://localhost:8080/logout">Wyloguj</a><br>
<a href="http://localhost:8080/admin/home">Głowny panel administratora</a>

</body>
</html>
