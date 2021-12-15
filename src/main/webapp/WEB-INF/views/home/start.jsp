<%@ taglib prefix="i18n" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: szymon
  Date: 08.12.2021
  Time: 10:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<sec:authorize access="!isAuthenticated()">
    <h1><i18n:message code="start"/></h1>
    <p>Żeby rozpocząć nauke kliknij proszę przycisk <strong>Logowanie</strong></p>
    <form action="<c:url value="/login"/>" method="get">
        <input type="submit" value="Logowanie">
    </form>
</sec:authorize>
<sec:authorize access="isAuthenticated()">
    <h1>Witaj <sec:authentication property="principal.username"/> ! </h1>
    <p>Wybierz swój kurs</p>
    <p>Dostepne kursy:</p>
    <p><a href="/course/viewcourse">kursy</a></p>
<form action="<c:url value="http://localhost:8080/course/viewcourse"/>" method="get">
    <input type="submit" value="kursy">

</form>
    <form action="<c:url value="/logout"/>" method="post">
        <input type="submit" value="Wyloguj">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>
</sec:authorize>
</body>
</html>
