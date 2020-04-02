
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>AddBook</title>

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
            <img class="image_1" src="${pageContext.request.contextPath}/resource/img/logo2.png" alt="logo" height="50px" width="100px">
        </div>
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li class="home"><a href="${pageContext.request.contextPath}">Home</a></li>
                <li class="dropdown active home" ><a href="#" class="dropdown-toggle" data-toggle="dropdown">Book</a>
                    <ul class="dropdown-menu">
                        <li><a href="bookList.jsp">BookList</a></li>
                        <li class="active"><a href="addBook.jsp">AddBook</a></li>
                        <li><a href="delBook.jsp">DeleteBook</a></li>
                        <li><a href="editBook.jsp">EditBook</a></li>
                    </ul>
                </li>
                <li class="home"><a href="addBook.jsp">Reader</a></li>
                <li class="home"><a href="delBook.jsp">Records</a></li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
    <div class="jumbotron" style="background-color:#E6E6E6;color:black;margin-top:0px;margin-bottom:0px;">
        <h1 style="font-size:40px;color:purple;text-align:center"><em>Add Books</em></h1>
    </div>
    <div class="rg_area" style="background-color:white;margin:auto;height:900px;width:1000px;border:1px solid black;border-radius:3px;">
        <form style="padding-left:200px;padding-top:50px;padding-right:200px;"
          action="${pageContext.request.contextPath}/addbook" method="POST">
            <div><p style="font-size:20px;color:orange;">Please input the information of new books:</p></div>
            <div class="form-group">
                <label for="InputBookISBN">ISBN</label>
                <input type="text" class="form-control" id="InputBookISBN" placeholder="ISBN" name="isbn">
            </div>
            <div class="form-group">
            <label for="InputBookName">Name</label>
            <input type="text" class="form-control" id="InputBookName" placeholder="Name" name="name">
        </div>
            <div class="form-group">
            <label for="InputBookAuthor">Author</label>
            <input type="text" class="form-control" id="InputBookAuthor" placeholder="Author" name="author">
        </div>
            <div class="form-group">
            <label for="InputBookCategory">Category</label>
            <input type="text" class="form-control" id="InputBookCategory" placeholder="Category" name="category">
        </div>
            <div class="form-group">
            <label for="InputBookPrice">Price</label>
            <input type="text" class="form-control" id="InputBookPrice" placeholder="Price" name="price">
        </div>
            <div class="form-group">
            <label for="InputBookFloor">Floor</label>
            <input type="text" class="form-control" id="InputBookFloor" placeholder="Floor" name="floor">
        </div>
            <div class="form-group">
            <label for="InputBookShelf">Shelf</label>
            <input type="text" class="form-control" id="InputBookShelf" placeholder="Shelf" name="shelf">
        </div>
            <div class="form-group">
            <label for="InputBookArea">Area</label>
            <input type="text" class="form-control" id="InputBookArea" placeholder="Area" name="area">
        </div>
            <div class="form-group">
            <label for="InputBookAmount">Amount</label>
            <input type="text" class="form-control" id="InputBookAmount" placeholder="Amount" name="amount">
        </div>
            <button type="submit" class="btn btn-default">Add</button>
    </form>
    </div>
    <div class="rg_5">Copyright @Mandarin-Library</div>

<!-- Controls -->


</body>
</html>
