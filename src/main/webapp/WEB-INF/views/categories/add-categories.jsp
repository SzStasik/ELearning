<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: szymon
  Date: 17.12.2021
  Time: 13:42
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
    <div><label> Nazwa Kategorii : <input type="text" name="name"/> </label></div>
    <div><input type="submit" value="Dodaj"/></div>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </sec:authorize>
</body>
</body>
</html>
