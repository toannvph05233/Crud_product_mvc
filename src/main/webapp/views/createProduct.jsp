<%--
  Created by IntelliJ IDEA.
  User: johntoan98gmail.com
  Date: 27/12/2021
  Time: 10:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
        </tr>
        <tr>
            <td><input name="id" placeholder="id"></td>
            <td><input name="name" placeholder="name"></td>
            <td><input name="price" placeholder="name"></td>
            <td><input name="img" placeholder="img"></td>
        </tr>
    </table>
    <button type="submit">Create</button>
</form>
</body>
</html>
