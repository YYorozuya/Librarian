<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Login</title>

    <!-- Bootstrap -->
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <style>
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
        <!-- Collect the nav links, forms, and other content for toggling --><!-- /.navbar-collapse -->
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
