<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 2022-07-11
  Time: 10:44 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Category</title>
</head>
<body>

<center>
    <h1>Category Management</h1>
    <h2>
        <a href="/categories?action=create">Add New Category</a>
    </h2>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Category</h2></caption>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Description</th>
            <th>isActive</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="category" items="${categories}">
            <tr>
                <td><c:out value="${category.getId()}"/></td>
                <td><c:out value="${category.getName()}"/></td>
                <td><c:out value="${category.getDescription()}"/></td>
                <td><c:out value="${category.isActive()}"/></td>
                <td>
                    <a href="/categories?action=edit&id=${category.getId()}">Edit</a>
                    <a href="/categories?action=delete&id=${category.getId()}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>


</body>
</html>
