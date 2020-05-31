<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>PostNews</title>

    <!-- Bootstrap -->
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
    <script src="https://cdn.staticfile.org/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
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
                <li class="home"><a href="${pageContext.request.contextPath}/">Home</a></li>
                <li class="dropdown active home" ><a href="#" class="dropdown-toggle" data-toggle="dropdown">Book</a>
                    <ul class="dropdown-menu">
                        <li><a href="bookList.jsp">BookList</a></li>
                        <li class="active"><a href="addBook.jsp">AddBook</a></li>
                        <li><a href="delBook.jsp">DeleteBook</a></li>
                        <li><a href="editBook.jsp">EditBook</a></li>
                    </ul>
                </li>
                <li class="dropdown home"><a href="addBook.jsp">Reader</a>
                    <ul class="dropdown-menu">
                        <li><a href="bookList.jsp">Register</a></li>
                        <li><a href="addBook.jsp">Edit</a></li>
                        <li><a href="delBook.jsp">Delete</a></li>
                        <li><a href="editBook.jsp">History</a></li>
                    </ul>
                </li>
                <li class="home"><a href="delBook.jsp">Records</a></li>
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
    <h1 style="font-size:40px;color:purple;text-align:center"><em>Post News</em></h1>
</div>
<div class="rg_area" style="background-color:white;margin:auto;width:70%;border:1px solid black;border-radius:3px;">
    <form style="padding-left:200px;padding-top:50px;padding-right:200px;padding-bottom:50px;"
          action="${pageContext.request.contextPath}/addbook" method="POST">
        <div><p style="font-size:20px;color:orange;">Please input the content of this news:</p></div>
        <div class="form-group">
            <label for="InputBookName">Title</label>
            <input type="text" class="form-control" id="InputBookName" placeholder="Title" name="title"
                   required = "required" pattern=".{1,50}">
        </div>
        <div class="form-group">
            <label for="Content">Content</label>
            <textarea class="form-control" rows="10" id="Content" name="content" required = "required"></textarea>
        </div>
        <button type="submit" class="btn btn-default">Add</button>

    </form>
</div>
<div class="rg_5">Copyright @Mandarin-Library</div>

<!-- Controls -->


</body>
</html>
