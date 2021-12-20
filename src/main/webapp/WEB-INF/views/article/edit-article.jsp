<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: szymon
  Date: 17.12.2021
  Time: 16:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Edytor Artykułów</h1>
<form:form method="post" modelAttribute="article">
   <form:hidden path="id"/>
    <label>Nazwa
        <form:input path="name"/>
    </label><br>
    <label>Opis
        <form:input path="description"/>
    </label><br>
    <input type="submit" value="Zapisz">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form:form>
</body>
</html>
