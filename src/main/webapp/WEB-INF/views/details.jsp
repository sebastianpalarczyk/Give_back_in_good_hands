<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<<<<<<< HEAD
<%--
  Created by IntelliJ IDEA.
  User: sebastian
  Date: 18.02.2021
  Time: 15:56
=======
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: sebastian
  Date: 17.02.2021
  Time: 23:02
>>>>>>> origin/main
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Oddam w dobre ręce</title>
</head>
<body>
<form:form action="/app/details/${donation.id}" method="post" modelAttribute="donation">
    Szczegóły darowizny:<br>
    Data odebrania: <form:input path="dateReceived" type="date"/><br>
    Potwierdzenie odbioru<form:checkbox path="received" value="${donation.received}"/><br>
    <button type="submit">Zapisz</button>
</form:form>
<br>
<a href="http://localhost:8080/logout">Wyloguj</a><br>
<a href="http://localhost:8080/admin/home">Głowny panel administratora</a>
</body>
</html>
