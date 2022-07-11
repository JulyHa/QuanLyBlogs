<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 2022-07-07
  Time: 02:49 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Show list user</title>
</head>
<body>

<center>
    <h1>User Management</h1>
    <h2>
        <a href="/users?action=create">Add New User</a>
    </h2>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Users</h2></caption>
        <tr>
            <th>ID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Address</th>
            <th>Phone Number</th>
            <th>User name</th>
            <th>Email</th>
            <th>Password</th>
            <th>Create time</th>
            <th>Update time</th>
            <th>isActive</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="user" items="${listUser}">
            <tr>
                <td><c:out value="${user.getId()}"/></td>
                <td><c:out value="${user.getFirstName()}"/></td>
                <td><c:out value="${user.getLastName()}"/></td>
                <td><c:out value="${user.getAddress()}"/></td>
                <td><c:out value="${user.getPhoneNumber()}"/></td>
                <td><c:out value="${user.getUsername()}"/></td>
                <td><c:out value="${user.getEmail()}"/></td>
                <td><c:out value="${user.getPassword()}"/></td>
                <td><c:out value="${user.getCreateTime()}"/></td>
                <td><c:out value="${user.getUpdateTime()}"/></td>
                <td><c:out value="${user.isStatus()}"/></td>
                <td>
                    <a href="<c:url value="/users?action=edit&id=${user.id}"/>">Edit</a>
                    <a href="<c:url value="/users?action=delete&id=${user.id}"/>">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>


</body>
</html>
