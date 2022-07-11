<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 2022-07-08
  Time: 04:33 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>
<center>
    <h1>User Management</h1>
    <h2>
        <a href="users?action=users">List All Users</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Edit User</h2>
            </caption>
            <c:if test="${user != null}">
                <input type="hidden" name="id" value="<c:out value='${user.id}' />"/>
            </c:if>
            <tr>
                <th>First Name:</th>
                <td>
                    <input type="text" name="firstName" size="45"
                           value="<c:out value='${user.firstName}'/>"
                    />
                </td>
            </tr>
            <tr>
                <th>Last Name:</th>
                <td>
                    <input type="text" name="lastName" size="45"
                           value="<c:out value='${user.lastName}'/>" />
                </td>
            </tr>
            <tr>
                <th>Address:</th>
                <td>
                    <input type="text" name="address" id="address" size="45"
                           value="<c:out value='${user.address}'/>" />
                </td>
            </tr>
            <tr>
                <th>Phone Number:</th>
                <td>
                    <input type="text" name="phoneNumber" id="phoneNumber" size="45"
                           value="<c:out value='${user.phoneNumber}'/>" />
                </td>
            </tr>
            <tr>
                <th>User Name:</th>
                <td>
                    <input type="text" name="username" id="username" size="45"
                           value="<c:out value='${user.username}'/>" />
                </td>
            </tr>
            <tr>
                <th>User Email:</th>
                <td>
                    <input type="text" name="email" id="email" size="45"
                           value="<c:out value='${user.email}'/>" />
                </td>
            </tr>
            <tr>
                <th>Password:</th>
                <td>
                    <input type="text" name="password" id="password" size="15"
                           value="<c:out value='${user.password}'/>" />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>
    </form>
</div>
</body>
</html>
