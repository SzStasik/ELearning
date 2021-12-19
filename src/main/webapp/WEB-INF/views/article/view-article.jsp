<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: szymon
  Date: 17.12.2021
  Time: 14:48
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
            <th>Nazwa</th>
            <th>Opis</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${article}" var="article">
            <tr>
                <td>${article.name}</td>
                <td>${article.description}</td>
                <td><a href="/article/delete/${article.id}"><button>Usuń</button></a></td>
                <td><a href="/article/edit/${article.id}"><button>Edytuj</button></a> </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div><a href="add"/><button>Dodaj</button></a> </div>
    <form action="<c:url value="/logout"/>" method="post">
        <input type="submit" value="Wyloguj">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>
</sec:authorize>
</body>
</html>
