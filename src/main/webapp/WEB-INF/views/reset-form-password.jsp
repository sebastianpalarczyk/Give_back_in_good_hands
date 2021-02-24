<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: sebastian
  Date: 24.02.2021
  Time: 15:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Oddam w dobre ręce</title>
</head>
<body>
<form:form modelAttribute="newUser" method="post" action="/new-password/${newUser.id}">
      Nowe hasło: <form:input path="password" type="password" placeholder="Nowe hasło"  />
    <button type="submit">Zapisz</button>
</form:form>
</body>
</html>
