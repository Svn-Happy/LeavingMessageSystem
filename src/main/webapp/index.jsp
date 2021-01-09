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
            margin:0 auto;
            border: 1px solid #cccccc;
            width: 20%;
            background-color: #F6F8FA;
            padding: 20px;
        }
    </style>

</head>
<body>
<h1 style="text-align: center">Login</h1>
    <div id="d1">
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
        <div style="text-align:center">
            <button type="submit" class="btn btn-default" >login</button>
        </div>
        <a href="register.jsp">>>sign in</a>
    </form>
    </div>

</body>
</html>
