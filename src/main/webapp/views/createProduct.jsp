<%--
  Created by IntelliJ IDEA.
  User: johntoan98gmail.com
  Date: 27/12/2021
  Time: 10:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post">
    <table border="1">
        <tr>
            <th>id</th>
            <th>name</th>
            <th>price</th>
            <th>img</th>
            <th>Category</th>
        </tr>
        <tr>
            <td><input name="id" placeholder="id"></td>
            <td><input name="name" placeholder="name"></td>
            <td><input name="price" placeholder="name"></td>
            <td><input name="img" placeholder="img"></td>
            <td>
                <select name="categoriesId">
                    <c:forEach items="${categories}" var="c">
                        <option value="${c.id}">${c.name}</option>
                    </c:forEach>
                </select>
            </td>

        </tr>
    </table>
    <button type="submit">Create</button>
</form>
</body>
</html>
