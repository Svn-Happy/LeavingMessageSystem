<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Login</title>
    <link href="bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <script src="bootstrap-3.3.7-dist/js/jquery1.4.js"></script>

    <style>
        #d1{
            margin-left: 400px;
            margin-top: 20px;
            border: 1px solid #cccccc;
            width: 30%;
        }
    </style>

</head>
<body>

<div id="d1">
    <h1 style="text-align: center">Login</h1>
<form action="/login" method="post">
    <div class="form-group">
        <label for="name">username</label>
        <input type="text"  class="form-control" name="username" id="name" placeholder="please enter username..." >
    </div>
    <span>
        ${msg}
    </span>
    <span>
        ${error}
    </span>
    <div class="form-group">
        <label for="Password">password</label>
        <input type="password" class="form-control" name="password" id="Password" placeholder="please enter password...">
    </div>
    <p align="center">
        <button type="submit" class="btn btn-default" >login</button>
    </p>
    <a href="register.jsp">>>sign in</a>
</form>
</div>

</body>
</html>
