<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: szymon
  Date: 16.12.2021
  Time: 09:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<sec:authorize access="isAuthenticated()">
<table>
    <thead>
    <tr>
        <th>Id</th>
        <th>Nazwa</th>
        <th>Email</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.username}</td>
            <td>${user.email}</td>
            <td><a href="/users/delete/${user.id}"><button>Usuń</button></a></td>
            <td><a href="/users/edit/${user.id}"><button>Edytuj</button></a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
    <div><a href="users/add"/><button>Dodaj</button></a> </div>
<form action="<c:url value="/logout"/>" method="post">
    <input type="submit" value="Wyloguj">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>
</sec:authorize>
</body>
</html>
