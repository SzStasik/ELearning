<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: szymon
  Date: 08.12.2021
  Time: 12:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1 class="text-color-darker">Logowanie</h1>
<form method="post">
    <div><label> Login : <input type="text" name="username"/> </label></div>
    <div><label> Hasło: <input type="password" name="password"/> </label></div>
    <div><input type="submit" value="Logowanie"/></div>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>
<p>Jeśli nie masz konta kliknij <a href="http://localhost:8080/register" rel="noopener"><strong>Rejestracja</strong></a> </p>
</form>
</body>
</html>
