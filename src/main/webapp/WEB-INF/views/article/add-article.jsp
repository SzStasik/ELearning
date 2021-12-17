<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: szymon
  Date: 17.12.2021
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<sec:authorize access="isAuthenticated()">
<form method="post">
    <div><label> Nazwa Artykułu  : <input type="text" name="name"/> </label></div>
    <div><label> Opis Artykułu  : <input type="text" name="description"/> </label></div>
    <div><input type="submit" value="Dodaj"/></div>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </sec:authorize>
</body>
</html>
