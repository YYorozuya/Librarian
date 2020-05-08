<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Home</title>

    <!-- Bootstrap -->
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
    <script src="https://cdn.staticfile.org/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

  <%--  <style>
        body{
            background-color:#666666;
        }
        .image_1{
            padding-right:10px;
        }
        .home{
            padding-right:20px;
        }
        .rg_5{
            border:1px;
            background-color: orange;
            text-align: center;
            height: 40px;
            font-size: 15px;
            color:grey;
            clear:both;
        }
    </style>--%>

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
                        <li><a href="Auth/bookList.jsp">BookList</a></li>
                        <li><a href="Auth/addBook.jsp">AddBook</a></li>
                        <li><a href="Auth/delBook.jsp">DeleteBook</a></li>
                        <li><a href="Auth/editBook.jsp">EditBook</a></li>
                        <li><a href="Auth/searchBook.jsp">searchBook</a></li>
                    </ul>
                </li>
                <li class="dropdown home"><a href="#" class="dropdown-toggle" data-toggle="dropdown">Reader</a>
                    <ul class="dropdown-menu">
                        <li><a href="Auth/readerList.jsp">List</a></li>
                        <li><a href="Auth/register.jsp">Register</a></li>
                        <li><a href="Auth/editReader.jsp">Edit</a></li>
                        <li><a href="Auth/delReader.jsp">Delete</a></li>
                        <li><a href="Auth/history.jsp">History</a></li>
                    </ul>
                </li>
                <li class="dropdown home"><a href="#" class="dropdown-toggle" data-toggle="dropdown">Business</a>
                    <ul class="dropdown-menu">
                        <li><a href="Auth/lendBook.jsp">Lend</a></li>
                        <li><a href="Auth/returnBook.jsp">Return</a></li>
                        <li><a href="Auth/editReader.jsp">Pay Fine</a></li>
                        <li><a href="Auth/history.jsp">History</a></li>
                    </ul>
                </li>
                <li class="home"><a href="Auth/delBook.jsp">Records</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <% //判断是否为登陆
                    String id = (String) session.getAttribute("LibrarianID");
                    if(id == null){
                %>
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
        <h1 style="padding-left:20px;">Welcome to Mandarin-Library, Dear <strong>Librarian!</strong></h1>
    </div>

    <div id="carousel-example-generic" class="carousel slide" data-ride="carousel" >
    <!-- Indicators -->
    <ol class="carousel-indicators">
        <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
        <li data-target="#carousel-example-generic" data-slide-to="1"></li>
        <li data-target="#carousel-example-generic" data-slide-to="2"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">
        <div class="item active">
            <img src="${pageContext.request.contextPath}/img/pic1.jpg" alt=".." style="margin:auto;margin-top:0px;heiht:300px;width:100%;">
        </div>
        <div class="item">
            <img src="${pageContext.request.contextPath}/img/pic2.jpg" alt=".." style="margin:auto;margin-top:0px;heiht:200px;">
        </div>
        <div class="rg_5">Copyright @Mandarin-Library</div>
    </div>

    <!-- Controls -->
    <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
    </a>
</div>

</body>
</html>


