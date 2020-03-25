<%@ page import="java.util.List" %>
<%@ page import="com.example.entity.Book" %>
<%@ page import="com.example.service.BookService" %>
<%@ page contentType="text/html;charset=UTF-8"%>


<html>
<body>
<%
    List<Book> bookList = BookService.findAll();
%>
<table border="1">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Author</th>
        <th>Category</th>
        <th>Price</th>
        <th>Floor</th>
        <th>Shelf</th>
        <th>Area</th>
        <th>Num</th>
    </tr>
    <%for ( Book book:bookList){ %>
    <tr>
        <td><%=book.getId()%></td>
        <td><%=book.getName()%></td>
        <td><%=book.getAuthor()%></td>
        <td><%=book.getCategory()%></td>
        <td><%=book.getPrice()%></td>
        <td><%=book.getFloor()%></td>
        <td><%=book.getShelf()%></td>
        <td><%=book.getArea()%></td>
        <td><%=book.getNum()%></td>
    </tr>
    <%}%>

</table>

</body>
</html>
