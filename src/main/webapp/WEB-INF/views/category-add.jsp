<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: sebastian
  Date: 11.02.2021
  Time: 14:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form action="/admin/category/add" method="post" modelAttribute="category">
    Nazwa kategorii: <form:input type="text" path="name"/><br>
    <button type="submit">Zapisz</button>
</form:form>
<br>
<a href="http://localhost:8080/logout">Wyloguj</a><br>
<a href="http://localhost:8080/admin/home">Głowny panel administratora</a>
</body>
</html>