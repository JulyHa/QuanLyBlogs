<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="fonts/icomoon/style.css">

    <link rel="stylesheet" href="css/owl.carousel.min.css">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="css/bootstrap.min.css">

    <!-- Style -->
    <link rel="stylesheet" href="css/style.css">

    <title>Login Blogs</title>
</head>
<body>


<div class="d-lg-flex half">
    <div class="bg order-1 order-md-2" style="background-image: url('images/bg_1.jpg');"></div>
    <div class="contents order-2 order-md-1">

        <div class="container">
            <div class="row align-items-center justify-content-center">
                <div class="col-md-7">
                    <h3>Login to <strong>Blogs</strong></h3>
                    <p class="mb-4">Where to write but secret lines.</p>
                    <form action="/users?action=login" method="post">
                        <div class="form-group first">
                            <label for="username">Username</label>
                            <input type="text" class="form-control" placeholder="Username or your-email@gmail.com" name="username" id="username">
                        </div>
                        <div class="form-group last mb-3">
                            <label for="password">Password</label>
                            <input type="password" class="form-control" placeholder="Password" name="password" id="password">
                        </div>

                        <div class="d-flex mb-5 align-items-center">
                            <span class="ml-auto"><a href="signIn.jsp" class="signIn">Sign In</a></span>
                        </div>

                        <input type="submit" value="Log In" class="btn btn-block btn-primary">

                    </form>
                </div>
            </div>
        </div>
    </div>


</div>



<script src="backend/js/jquery-3.3.1.min.js"></script>
<script src="backend/js/popper.min.js"></script>
<script src="backend/js/bootstrap.min.js"></script>
<script src="backend/js/main.js"></script>
</body>

</html>