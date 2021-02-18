<%--
  Created by IntelliJ IDEA.
  User: sebastian
  Date: 02.02.2021
  Time: 16:25
  To change this template use File | Settings | File Templates.
--%>
<<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <link rel="stylesheet" href="<c:url value="resources/css/style.css"/>" />
</head>
<body>
<header>
    <jsp:include page="header.jsp"></jsp:include>
</header>

<section class="login-page">
    <h2>Załóż konto</h2>
    <form:form mathod="POST" modelAttribute="user">
        <div class="form-group">
            <form:input type="email" name="email" path="email" placeholder="Email" />
        </div>
        <div class="form-group">
            <form:input type="text" name="username" path="username" placeholder="UserName" />
        </div>
        <div class="form-group">
            <form:input type="text" name="firstName" path="firstName" placeholder="Imię" />
        </div>
        <div class="form-group">
            <form:input type="text" name="lastName" path="lastName" placeholder="Nazwisko" />
        </div>
        <div class="form-group">
            <form:input type="password" name="password" path="password" placeholder="Hasło" />
        </div>
        <div class="form-group">
            <input type="password" name="password2" placeholder="Powtórz hasło" />
        </div>

        <div class="form-group form-group--buttons">
            <a href="login.html" class="btn btn--without-border">Zaloguj się</a>
            <button class="btn" type="submit">Załóż konto</button>
        </div>
    </form:form>
</section>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>