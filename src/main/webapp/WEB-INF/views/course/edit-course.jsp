<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: szymon
  Date: 13.12.2021
  Time: 20:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>
<h1>Edit Form</h1>
<form:form method="post" modelAttribute="course">
    <form:hidden path="id"/>
    <label>Opis
        <form:input path="description"/>
    </label><br>
    <label>Nazwa
        <form:input path="name"/>
    </label><br>
    <input type="submit" value="Zapisz">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form:form>
</body>
</html>
