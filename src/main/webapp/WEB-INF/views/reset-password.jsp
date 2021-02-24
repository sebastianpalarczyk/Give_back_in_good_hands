<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: sebastian
  Date: 24.02.2021
  Time: 12:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Oddam w dobre ręce</title>
</head>
<body>
<h1>
<form:form method="post" action="/reset-password" modelAttribute="user">
   Podaj Twój adres email:  <form:input path="email" type="email"/>
    <button type="submit">Wyślij</button>
</form:form>
</h1>
</body>
</html>
