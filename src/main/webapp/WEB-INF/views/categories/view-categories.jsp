<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: szymon
  Date: 15.12.2021
  Time: 10:41
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
            <th>(Nazwa kursu)</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${categories}" var="categories">
            <tr>
                <td>${categories.name}</td>
                <td><a href="/article/${article.id}" rel="noopener"><button>Wybierz</button></a></td>
                <td><a href="/categories/delete/${categories.id}"><button>Usuń</button></a></td>
                <td><a href="/categories/edit/${categories.id}"><button>Edytuj</button></a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div><a href="/categories/add"/><button>Dodaj</button></a> </div>
    <div><a href="/course"/><button>Cofnij</button></a> </div>
    <form action="<c:url value="/logout"/>" method="post">
        <input type="submit" value="Wyloguj">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>
</sec:authorize>
</body>
</html>
