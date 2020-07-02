<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Login</title>

    <!-- Bootstrap -->
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
    <script src="https://cdn.staticfile.org/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <style>
        .login_part{
            border:1px solid white;
            height:500px;
            width:100%;
            background-image:url("${pageContext.request.contextPath}/img/loginpic.jpg");
            background-size:100%,100%;
        }
    </style>

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
                <li class="active home"><a href="${pageContext.request.contextPath}/">Home</a></li>
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
                <li class="dropdown home"><a href="#" class="dropdown-toggle" data-toggle="dropdown">History</a>
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
                    <a href="http://localhost:8080/admin/Login.html">Recovery</a>
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
    <div class="jumbotron" style="background-color:#E6E6E6;color:purple;margin-top:0px;margin-bottom:0px;">
        <h1 style="padding-left:20px;">Welcome to <strong>Mandarin-Library!</strong></h1>
</div>
    <div class="login_part">
        <div class="rg_area" style="margin-left:200px;margin-top:100px;height:300px;width:40%;border:1px;border-radius:3px;">
        <form style="margin-top:30px;margin-left:30px;margin-right:50px;"
            action="${pageContext.request.contextPath}/login" method="POST">
            <div><p style="font-size:20px;color:white;">Please input your information to log in:</p></div>
            <div class="form-group">
                <label for="ID" style="color:orange;">Librarian ID</label>
                <input type="text" class="form-control" id="ID" placeholder="Librarian ID" name="id">
            </div>
            <div class="form-group">
                <label for="passwd" style="color:orange;">Password</label>
                <input type="password" class="form-control" id="passwd" placeholder="Password" name="passwd">
            </div>
            <%
                Object test = request.getAttribute("failed");
                if (test != null){
            %>
            <div class="alert alert-danger">Failed. Wrong Password!</div>
            <% }%>
            <button type="submit" class="btn btn-default">Login</button>
        </form>
    </div>
    </div>

<div class="rg_5">Copyright @Mandarin-Library</div>

<!-- Controls -->

</body>
</html>
