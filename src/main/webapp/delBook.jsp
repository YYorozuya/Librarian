<%--
  Created by IntelliJ IDEA.
  User: 75192
  Date: 2020/3/25
  Time: 18:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>delbook</title>
</head>
<body>
<h1>Input the ID of the book you want to detele:</h1>
<form action="${pageContext.request.contextPath}/delbook" method="POST">
    <table>
        <tr>
            <td>Num</td>
            <td><input type="text" name="id"></td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="Delete" >
            </td>
        </tr>
    </table>
</form>


</body>
</html>
