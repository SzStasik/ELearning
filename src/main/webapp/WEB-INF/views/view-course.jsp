<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<h1>Hello</h1>
<table>
    <thead>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Description</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${course}" var="course">
        <tr>
            <td>${course.course_id}</td>
            <td>${course.name}</td>
            <td>${course.description}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
