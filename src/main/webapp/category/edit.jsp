<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 2022-07-11
  Time: 12:39 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Edit Category</title>
</head>
<body>
<center>
    <h1>Category Management</h1>
    <h2>
        <a href="users?action=users">List All Category</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Edit Category</h2>
            </caption>
            <c:if test="${category != null}">
                <input type="hidden" name="id" value="<c:out value='${category.id}' />"/>
            </c:if>
            <tr>
                <th>Name:</th>
                <td>
                    <input type="text" name="name" size="45"
                           value="<c:out value='${category.name}'/>"
                    />
                </td>
            </tr>
            <tr>
                <th>Description:</th>
                <td>
                    <input type="text" name="description" size="45"
                           value="<c:out value='${category.description}'/>" />
                </td>
            </tr>
<%--            <tr>--%>
<%--                <th>Status:</th>--%>
<%--                <td>--%>
<%--                    <input type="text" name="status" id="status" size="15"--%>
<%--                           value="<c:out value='${category.status}'/>" />--%>
<%--                </td>--%>
<%--            </tr>--%>
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
