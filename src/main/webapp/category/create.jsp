<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 2022-07-11
  Time: 12:39 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                <h2>Add New Category</h2>
            </caption>
            <tr>
                <th>Name:</th>
                <td>
                    <input type="text" name="name" id="name" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Description:</th>
                <td>
                    <input type="text" name="description" id="description" size="45"/>
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
