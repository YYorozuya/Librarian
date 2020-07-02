<%@ page import="java.util.List" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="java.time.Instant" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.time.ZoneId" %>
<%@ page import="com.example.domain.FineRecord" %>
<%@ page import="com.example.service.HistoryService" %>
<%@ page contentType="text/html;charset=UTF-8"%>


<% List<FineRecord> list = HistoryService.fineList();%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>LendingHistory</title>

    <!-- Bootstrap -->
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
    <script src="https://cdn.staticfile.org/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/JsBarcode.all.min.js"></script>
</head>

<body>

<nav class="navbar navbar-default" style="margin-bottom:0px;">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <img class="image_1" src="${pageContext.request.contextPath}/img/logo2.png" alt="logo" height="50px" width="100px">
        </div>
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li class="dropdown home"><a href="${pageContext.request.contextPath}/">Home</a></li>
                <li class="dropdown home" ><a href="#" class="dropdown-toggle" data-toggle="dropdown">Book</a>
                    <ul class="dropdown-menu">
                        <li><a href="${pageContext.request.contextPath}/book/bookList.jsp">BookList</a></li>
                        <li><a href="${pageContext.request.contextPath}/book/addBook.jsp">AddBook</a></li>
                        <li><a href="${pageContext.request.contextPath}/book/delBook.jsp">DeleteBook</a></li>
                        <li><a href="${pageContext.request.contextPath}/book/editBook.jsp">EditBook</a></li>
                        <li><a href="${pageContext.request.contextPath}/book/searchBook.jsp">SearchBook</a></li>
                        <li><a href="${pageContext.request.contextPath}/book/bookSettings.jsp">BookSetting</a></li>
                    </ul>
                </li>
                <li class="dropdown home"><a href="#" class="dropdown-toggle" data-toggle="dropdown">Reader</a>
                    <ul class="dropdown-menu">
                        <li><a href="${pageContext.request.contextPath}/reader/readerList.jsp">List</a></li>
                        <li><a href="${pageContext.request.contextPath}/reader/register.jsp">Register</a></li>
                        <li><a href="${pageContext.request.contextPath}/reader/editReader.jsp">Edit</a></li>
                        <li><a href="${pageContext.request.contextPath}/reader/delReader.jsp">Delete</a></li>
                        <li><a href="${pageContext.request.contextPath}/reader/searchReader.jsp">Search</a></li>
                        <li><a href="${pageContext.request.contextPath}/reader/readerHistory.jsp">History</a></li>
                    </ul>
                </li>
                <li class="dropdown home"><a href="#" class="dropdown-toggle" data-toggle="dropdown">Business</a>
                    <ul class="dropdown-menu">
                        <li><a href="${pageContext.request.contextPath}/business/lendBook.jsp">Lend Book</a></li>
                        <li><a href="${pageContext.request.contextPath}/business/returnBook.jsp">Return Book</a></li>
                        <li><a href="${pageContext.request.contextPath}/business/payFine.jsp">Pay Fine</a></li>
                    </ul>
                </li>
                <li class="active home"><a href="#" class="dropdown-toggle" data-toggle="dropdown">History</a>
                    <ul class="dropdown-menu">
                        <li><a href="${pageContext.request.contextPath}/history/lendingHistory.jsp">Lending</a></li>
                        <li><a href="${pageContext.request.contextPath}/history/fineHistory.jsp">Fine</a></li>
                        <li><a href="${pageContext.request.contextPath}/history/delHistory.jsp">Delete</a></li>
                        <li><a href="${pageContext.request.contextPath}/history/incomeHistory.jsp">Income</a></li>
                    </ul>
                </li>
                <li class="dropdown home"><a href="${pageContext.request.contextPath}/news/postnews.jsp" class="dropdown-toggle" data-toggle="dropdown">News</a>
                    <ul class="dropdown-menu">
                        <li><a href="${pageContext.request.contextPath}/news/postnews.jsp">Post News</a></li>
                    </ul>
                </li>

            </ul>
            <ul class="nav navbar-nav navbar-right">
                <% //判断是否为登陆
                    String id = (String) session.getAttribute("LibrarianID");
                    if(id == null){
                %>
                <li>
                    <a href="${pageContext.request.contextPath}/login.jsp">Recovery</a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/login.jsp">Login</a>
                </li>
                <%
                } else {
                %>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><%=id%><strong class="caret"></strong></a>
                    <ul class="dropdown-menu">
                        <li>
                            <a href="${pageContext.request.contextPath}/logout">Log out</a>
                        </li>
                    </ul>
                </li>
                <% } %>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>

<div class="jumbotron" style="background-color:#E6E6E6;color:black;margin-top:0px;margin-bottom:0px;">
    <h1 style="font-size:40px; color:purple; text-align:center"><em>Fine History</em></h1>
</div>

<div class="rg_area" style="background-color:white;margin:auto;width:70%;border:1px solid black;border-radius:3px;">
    <table class="table table-striped" style="width:95%;margin:auto;margin-bottom:10%">
        <thead>
        <tr>
            <th>ID</th>
            <th>BookID</th>
            <th>ReaderID</th>
            <th>BorrowTime</th>
            <th>ReturnTime</th>
            <th>Amount</th>
            <th>PayTime</th>
        </tr>
        </thead>
        <tbody>
        <%
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            for (FineRecord fine: list){
                Instant instantB = Instant.ofEpochSecond(fine.getRecord().getBtime());
                LocalDateTime btime = LocalDateTime.ofInstant(instantB, ZoneId.systemDefault());
                Instant instantR = Instant.ofEpochSecond(fine.getRecord().getRtime());
                LocalDateTime rtime = LocalDateTime.ofInstant(instantR, ZoneId.systemDefault());
        %>
        <tr>
            <td><%=fine.getRecord().getId()%></td>
            <td><%=fine.getRecord().getBkid()%></td>
            <td><%=fine.getRecord().getRid()%></td>
            <td><%=formatter.format(btime)%></td>
            <td><%=formatter.format(rtime)%></td>
            <td><%=fine.getAmount()%></td>
            <% if(fine.getTime() > 0) {
                Instant instantP = Instant.ofEpochSecond(fine.getTime());
                LocalDateTime ptime = LocalDateTime.ofInstant(instantP, ZoneId.systemDefault());
            %> <td><%=formatter.format(ptime)%></td>
            <%} else {%>  <td>Not yet</td> <%}%>
        </tr>
        <% }%>
        </tbody>
    </table>
</div>

<div class="rg_5">Copyright @Mandarin-Library</div>
</body>
</html>