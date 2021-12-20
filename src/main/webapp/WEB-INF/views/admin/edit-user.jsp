<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: szymon
  Date: 18.12.2021
  Time: 12:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Edytor Użytkowników</h1>
<form:form method="post" modelAttribute="user">
    <form:hidden path="id"/>
    <label>Nazwa
        <form:input path="username"/>
    </label><br>
    <label>Hasło
        <form:input path="password"/>
    </label><br>
    <label>E-Mail
        <form:input path="email"/>
    </label><br>
    <input type="submit" value="Zapisz">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form:form>
</body>
</html>
