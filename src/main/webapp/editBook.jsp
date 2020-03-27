<%--
  Created by IntelliJ IDEA.
  User: 75192
  Date: 2020/3/25
  Time: 18:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>editbook</title>
</head>
<body>
<h1>Input the  ID to edit the exact book:</h1>
<form action="${pageContext.request.contextPath}/editbook" method="POST">
    <table>
        <tr>
            <td>Id</td>
            <td><input type="text" name="id"></td>
        </tr>
        <tr>
            <td>Name</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td>Author</td>
            <td><input type="text" name="author"></td>
        </tr>
        <tr>
            <td>Category</td>
            <td><input type="text" name="category"></td>
        </tr>
        <tr>
            <td>Price</td>
            <td><input type="text" name="price"></td>
        </tr>
        <tr>
            <td>Floor</td>
            <td><input type="text" name="floor"></td>
        </tr>
        <tr>
            <td>Shelf</td>
            <td><input type="text" name="shelf"></td>
        </tr>
        <tr>
            <td>Area</td>
            <td><input type="text" name="area"></td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="Edit">
            </td>
        </tr>
    </table>
</form>

</body>
</html>
