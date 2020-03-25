
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AddBook</title>
</head>
<body>
<h1>Input the information of the new book:</h1>
<form action="${pageContext.request.contextPath}/addbook" method="POST">
    <table>
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
            <td>Num</td>
            <td><input type="text" name="num"></td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="Add">
            </td>
        </tr>
    </table>
</form>

</body>
</html>
