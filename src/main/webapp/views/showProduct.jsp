<%--
  Created by IntelliJ IDEA.
  User: johntoan98gmail.com
  Date: 27/12/2021
  Time: 10:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
    <style>
        td, th{
            padding: 5px 5px;
        }
    </style>
</head>
<body>
<h1>Đây là trang Show Product</h1>
<button><a href="/product?action=create">Create</a></button>
<table border="1">
    <tr>
        <th>#</th>
        <th>name</th>
        <th>price</th>
        <th>img</th>
        <th>edit</th>
        <th>delete</th>
    </tr>
    <c:forEach items="${products}" var="p" varStatus="loop">
        <tr>
            <td>${loop.count}</td>
            <td>${p.getName()}</td>
            <td>${p.price}</td>
            <td><img src="${p.img}" width="150" height="100"></td>
            <td><button>edit</button></td>
            <td><button><a href="/product?action=delete&&id=${p.id}">delete</a></button></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
