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
    <title>Title</title>
</head>
<body>
<c:forEach var="element" items="${receivedDonations}">
    <c:out value="${element.id}"/>
    <c:out value="${element.city}"/>
    <c:out value="${element.street}"/>
    <c:out value="${element.received}"/>
    <c:out value="${element.dateReceived}"/>
</c:forEach>
</body>
</html>
