<%--&lt;%&ndash;--%>
<%--  Created by IntelliJ IDEA.--%>
<%--  User: ADMIN--%>
<%--  Date: 2022-07-11--%>
<%--  Time: 10:44 SA--%>
<%--  To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Category</title>--%>
<%--</head>--%>
<%--<body>--%>

<%--<center>--%>
<%--    <h1>Category Management</h1>--%>
<%--    <h2>--%>
<%--        <a href="/categories?action=create">Add New Category</a>--%>
<%--    </h2>--%>
<%--</center>--%>
<%--<div align="center">--%>
<%--    <table border="1" cellpadding="5">--%>
<%--        <caption><h2>List of Category</h2></caption>--%>
<%--        <tr>--%>
<%--            <th>ID</th>--%>
<%--            <th>Name</th>--%>
<%--            <th>Description</th>--%>
<%--            <th>isActive</th>--%>
<%--            <th>Actions</th>--%>
<%--        </tr>--%>
<%--        <c:forEach var="category" items="${categories}">--%>
<%--            <tr>--%>
<%--                <td><c:out value="${category.getId()}"/></td>--%>
<%--                <td><c:out value="${category.getName()}"/></td>--%>
<%--                <td><c:out value="${category.getDescription()}"/></td>--%>
<%--                <td><c:out value="${category.isActive()}"/></td>--%>
<%--                <td>--%>
<%--                    <a href="/categories?action=edit&id=${category.getId()}">Edit</a>--%>
<%--                    <a href="/categories?action=delete&id=${category.getId()}">Delete</a>--%>
<%--                </td>--%>
<%--            </tr>--%>
<%--        </c:forEach>--%>
<%--    </table>--%>
<%--</div>--%>


<%--</body>--%>
<%--</html>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <!-- Css -->
    <link rel="stylesheet" href="backend/dist/styles.css">
    <link rel="stylesheet" href="backend/dist/all.css">
    <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:400,400i,600,600i,700,700i" rel="stylesheet">
    <title>Blogs | Admin</title>
</head>

<body>
<!--Container -->
<div class="mx-auto bg-grey-lightest">
    <!--Screen-->
    <div class="min-h-screen flex flex-col">
        <!--Header Section Starts Here-->
        <header class="bg-nav">
            <div class="flex justify-between">
                <div class="p-1 mx-3 inline-flex items-center">
                    <i class="fas fa-bars pr-2 text-white" onclick="sidebarToggle()"></i>
                    <h1 class="text-white p-2">Logo</h1>
                </div>
                <div class="p-1 flex flex-row items-center">
                    <img onclick="profileToggle()" class="inline-block h-8 w-8 rounded-full" src="https://avatars0.githubusercontent.com/u/4323180?s=460&v=4" alt="">
<%--                    <a href="#" class="text-white p-2 no-underline hidden md:block lg:block">Admin</a>--%>
                    <a href="<c:url value="/users?action=logout"/>" class="bg-teal-300 cursor-pointer rounded p-1 mx-1 text-white">
                        Logout
                    </a>
                    <div id="ProfileDropDown" class="rounded hidden shadow-md bg-white absolute pin-t mt-12 mr-1 pin-r">
                        <ul class="list-reset">
                            <li><a href="#" class="no-underline px-4 py-2 block text-black hover:bg-grey-light">My account</a></li>
                            <li><a href="#" class="no-underline px-4 py-2 block text-black hover:bg-grey-light">Notifications</a></li>
                            <li><hr class="border-t mx-2 border-grey-ligght"></li>
                            <li><a href="#" class="no-underline px-4 py-2 block text-black hover:bg-grey-light">Logout</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </header>
        <!--/Header-->

        <div class="flex flex-1">
            <!--Sidebar-->
            <aside id="sidebar" class="bg-side-nav w-1/2 md:w-1/6 lg:w-1/6 border-r border-side-nav hidden md:block lg:block">
                <div class="flex">

                </div>
                <ul class="list-reset flex flex-col">
                    <li class=" w-full h-full py-3 px-2 border-b border-light-border ">
                        <a href="/users"
                           class="font-sans font-hairline hover:font-normal text-sm text-nav-item no-underline">
                            <i class="fas fa-tachometer-alt float-left mx-2"></i>
                            User
                            <span><i class="fas fa-angle-right float-right"></i></span>
                        </a>
                    </li>
                    <li class="w-full h-full py-3 px-2 border-b border-light-border">
                        <a href="/blogs"
                           class="font-sans font-hairline hover:font-normal text-sm text-nav-item no-underline">
                            <i class="fab fa-wpforms float-left mx-2"></i>
                            Blog
                            <span><i class="fa fa-angle-right float-right"></i></span>
                        </a>
                    </li>
                    <li class="w-full h-full py-3 px-2 border-b border-light-border">
                        <a href="/categories"
                           class="font-sans font-hairline hover:font-normal text-sm text-nav-item no-underline">
                            <i class="fas fa-grip-horizontal float-left mx-2"></i>
                            Category
                            <span><i class="fa fa-angle-right float-right"></i></span>
                        </a>
                    </li>
                </ul>

            </aside>
            <!--/Sidebar-->
            <!--Main-->
            <main class="bg-white-500 flex-1 p-3 overflow-hidden">

                <div class="flex flex-col">

                    <div class="flex flex-1  flex-col md:flex-row lg:flex-row mx-2">
                        <div class="mb-2 border-solid border-gray-300 rounded border shadow-sm w-full">
                            <div class="bg-gray-200 px-2 py-3 border-solid border-gray-200 border-b">
                                Category Table
                                <a href="<c:url value="/categories?action=create"/>" class="bg-teal-300 cursor-pointer rounded p-1 mx-1 text-white">
                                    <i class="fas fa-edit"></i></a>
                            </div>
                            <div class="p-3">
                                <table class="table-responsive w-full rounded">
                                    <thead>
                                    <tr>
                                        <th class="border w-1/4 px-4 py-2">ID</th>
                                        <th class="border w-1/6 px-4 py-2">Name</th>
                                        <th class="border w-1/6 px-4 py-2">Description</th>
                                        <th class="border w-1/5 px-4 py-2">isActive</th>
                                        <th class="border w-1/5 px-4 py-2">Actions</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="category" items="${categories}">
                                        <tr>
                                            <td class="border px-4 py-2"><c:out value="${category.getId()}"/></td>
                                            <td class="border px-4 py-2"><c:out value="${category.getName()}"/></td>
                                            <td class="border px-4 py-2"><c:out value="${category.getDescription()}"/></td>
                                            <td class="border px-4 py-2"><c:out value="${category.isActive()}"/></td>
<%--                                            <td class="border px-4 py-2">--%>
<%--                                                <i class="fas fa-check text-green-500 mx-2"></i>--%>
<%--                                                </td>--%>
                                            <td class="border px-4 py-2">
                                                <a href="<c:url value="/categories?action=edit&id=${category.id}"/>" class="bg-teal-300 cursor-pointer rounded p-1 mx-1 text-white">
                                                    <i class="fas fa-edit"></i></a>
                                                <a href="<c:url value="/categories?action=delete&id=${category.id}"/>" class="bg-teal-300 cursor-pointer rounded p-1 mx-1 text-red-500">
                                                    <i class="fas fa-trash"></i>
                                                </a>
                                            </td>
                                        </tr>
                                    </c:forEach>

                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    <!--/Grid Form-->
                </div>
            </main>
            <!--/Main-->
        </div>
        <!--Footer-->
        <footer class="bg-grey-darkest text-white p-2">
            <div class="flex flex-1 mx-auto">&copy; My Design</div>
        </footer>
        <!--/footer-->

    </div>

</div>

<script src="/backend/js/mainAdmin.js"></script>

</body>

</html>