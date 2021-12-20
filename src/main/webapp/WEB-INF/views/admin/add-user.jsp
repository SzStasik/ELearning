<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: szymon
  Date: 20.12.2021
  Time: 09:43
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
    <div><label> Login: <input type="text" name="username"/> </label></div>
    <div><label> Hasło: <input type="password" name="password"/> </label></div>
    <div><label> E-Mail: <input type="text" name="email"/> </label></div>
    <div><input type="submit" value="Dodaj"/></div>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </sec:authorize>
</body>
</html>
