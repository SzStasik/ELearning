<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: szymon
  Date: 13.12.2021
  Time: 13:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Course</title>
</head>
<body>
<sec:authorize access="isAuthenticated()">
    <h1 style="color:blue;">Dostepne kursy:</h1>
<table>
    <thead>
    <tr>
        <th>Nazwa</th>
        <th>Opis</th>
    </tr>
    </thead>
    <tbody>

    <c:forEach items="${course}" var="course" >

        <tr>
            <td>${course.name}</td>
            <td>${course.description}</td>
            <td><a href="/categories/${categories.id}" rel="noopener"><button>Wybierz</button></a></td>
            <td><a href="/course/delete/${course.id}"><button>Usuń</button></a></td>
            <td><a href="/course/edit/${course.id}"><button>Edytuj</button></a></td>
        </tr>
    </c:forEach>

    </tbody>
</table>
    <div><a href="/course/add"/><button>Dodaj</button></a> </div>
    <form action="<c:url value="/logout"/>" method="post">
        <input type="submit" value="Wyloguj">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>
</sec:authorize>
</body>
</html>
