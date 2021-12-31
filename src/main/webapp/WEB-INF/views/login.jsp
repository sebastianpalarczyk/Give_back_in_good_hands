<%--
  Created by IntelliJ IDEA.
  User: sebastian
  Date: 02.02.2021
  Time: 16:24
  To change this template use File | Settings | File Templates.
--%>
<<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
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
    <h2>Zaloguj się</h2>
    <form method="post">
        <div class="form-group">
            <input type="text" name="username"  placeholder="Nazwa użytkownika" />
        </div>
        <div class="form-group">
            <input type="password" name="password" placeholder="Hasło" id="password"/>
            <a href="http://localhost:8080/reset-password" class="btn btn--small btn--without-border reset-password">Przypomnij hasło</a>
        </div>

        <div class="form-group form-group--buttons">
            <a href="http://localhost:8080/register" class="btn btn--without-border">Załóż konto</a>
            <button class="btn" type="submit">Zaloguj się</button>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </div>
    </form>
</section>

    <jsp:include page="footer.jsp"></jsp:include>

</body>
</html>
