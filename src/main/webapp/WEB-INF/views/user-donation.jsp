<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: sebastian
  Date: 10.02.2021
  Time: 19:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Oddam w dobre ręce</title>
</head>
<body>
Odebrane darowizny od darczyńcy:<br>
<c:forEach var="element" items="${receivedDonations}">
    <c:out value="${element.id}"/>
    <c:out value="${element.city}"/>
    <c:out value="${element.street}"/>
    <c:out value="${element.received}"/>
    <c:out value="${element.dateReceived}"/>
    <a href="http://localhost:8080/app/details/${element.id}">Szczegóły</a><br>
</c:forEach>
<br>
Nieodbrane darowizny od darczyńcy:<br>
<c:forEach var="element" items="${noReceivedDonations}">
    <c:out value="${element.id}"/>
    <c:out value="${element.city}"/>
    <c:out value="${element.street}"/>
    <c:out value="${element.received}"/>
    <c:out value="${element.dateReceived}"/>
    <a href="http://localhost:8080/app/details/${element.id}">Szczegóły</a><br>
</c:forEach>
<br>
<a href="http://localhost:8080/logout">Wyloguj</a>
</body>
</html>
