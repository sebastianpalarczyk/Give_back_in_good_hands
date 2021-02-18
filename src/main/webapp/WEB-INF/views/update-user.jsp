<%--
  Created by IntelliJ IDEA.
  User: sebastian
<<<<<<< HEAD
  Date: 18.02.2021
  Time: 16:00
=======
  Date: 17.02.2021
  Time: 18:59
>>>>>>> origin/main
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>Oddam w dobre ręce</title>
    <link rel="stylesheet" href="<c:url value="../resources/css/style.css"/>" />
</head>
<body>
<header>
</header>

<section class="login-page">
    <h2>Edytuj konto</h2>
    <form:form mathod="POST" modelAttribute="userUpdate" action="/app/update/${userUpdate.id}">
        <div class="form-group">
            <form:input type="email" name="email" path="email" value="${userUpdate.email}" placeholder="Email" />
        </div>
        <div class="form-group">
            <form:input type="text" name="username" path="username" value="${userUpdate.username}" placeholder="UserName" />
        </div>
        <div class="form-group">
            <form:input type="text" name="firstName" path="firstName" value="${userUpdate.firstName}" placeholder="Imię" />
        </div>
        <div class="form-group">
            <form:input type="text" name="lastName" path="lastName" value="${userUpdate.lastName}" placeholder="Nazwisko" />
        </div>
        <div class="form-group">
            <form:input type="password"  path="password" name="password" placeholder="Hasło" />
        </div>
        <div class="form-group">
            <input type="password" name="password2"  value = "" placeholder="Powtórz hasło" />
        </div>

        <div class="form-group form-group--buttons">
            <button class="btn" type="submit">Zapisz zmiany</button>
        </div>
    </form:form>
    <br>
    <a href="http://localhost:8080/logout">Wyloguj</a><br>
    <a href="http://localhost:8080/admin/home">Głowny panel administratora</a>
</section>
</body>
</html>

