<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: szymon
  Date: 17.12.2021
  Time: 14:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Edit Categories</h1>
<form action="edit-categories.jsp" method="post">
    <table>
        <tr>
            <td>Categories ID:</td>
            <td><input type="text" name="${categories.id}"  /></td>
        </tr>
        <tr>
            <td>Categories Name:</td>
            <td><input type="text" name="${categories.name}" /></td>
        </tr>

        <tr>
            <td><button type="submit">Zapisz</button></td>
        </tr>
    </table>
</form>
</body>
</html>
