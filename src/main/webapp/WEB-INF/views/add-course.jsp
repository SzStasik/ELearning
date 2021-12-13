<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: szymon
  Date: 13.12.2021
  Time: 14:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Course</title>
</head>
<body>
<c:if test="${addCourseSuccess}">
    <div>Successfully added Course with Name: ${savedCourse.courseName}</div>
</c:if>

<c:url var="add-course" value="/WEB-INF/views"/>
<form:form action="${course}" method="post" modelAttribute="course">
    <form:label path="courseName">Course Name: </form:label> <form:input type="text" path="name"/>
    <form:label path="description">Description: </form:label> <form:input path="description"/>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <input type="submit" value="submit"/>
</form:form>
</body>
</html>
