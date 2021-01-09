<%--
  Created by IntelliJ IDEA.
  User: 73439
  Date: 2021/1/4
  Time: 16:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>sign in</title>
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
        <form action="/reg" method="post">
            <h1 style="text-align: center">Register</h1>
            <div class="form-group">
                <label for="name">username</label>
                <input type="text"  class="form-control" name="username" id="name" placeholder="please enter username..." >
            </div>
            <div class="form-group">
                <label for="Password">password</label>
                <input type="password" class="form-control" name="password" id="Password" placeholder="please enter password...">
            </div>
            <div class="form-group">
                <label for="Password2">verify password</label>
                <input type="password" class="form-control" name="password2" id="Password2" placeholder="please enter password again...">
            </div>
            <div class="form-group">
                <label for="VerificationCode">verification code</label>
                <input type="password" class="form-control" name="verificationCode" id="VerificationCode" placeholder="please enter code...">
                <br>
                <a href="#">send code</a>
            </div>
            <p align="center">
                <button type="submit" class="btn btn-default" >sign in</button>
            </p>
        </form>
    </div>
</body>
</html>
