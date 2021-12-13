<%--
  Created by IntelliJ IDEA.
  User: szymon
  Date: 08.12.2021
  Time: 12:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Rejestracja</h1>
<form method="post">
    <div><label> Login : <input type="text" name="username"/> </label></div>
    <div><label> E-Mail : <input type="text" name="email"/> </label></div>
    <div><label> Nick : <input type="text" name="details"/> </label></div>
    <div><label> Hasło: <input type="password" name="password"/> </label></div>
    <div><input type="submit" value="Zarejestruj"/></div>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>
</body>
</html>
