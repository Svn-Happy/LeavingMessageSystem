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
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../css/reg.css"/>
    <link rel="stylesheet" href="css/iconfont.css" />
    <title>注册</title>
</head>
<body>
<video id="v1" autoplay loop muted>
    <source src="../img/girl.mp4" type="video/mp4"  />
</video>
<div id="bigBox">
    <h1>Create Account</h1>
    <div class="inputBox">
        <form action="/reg" method="post">
            <div class="inputText">
                <span class="iconfont icon-nickname"></span>
                <input type="text" placeholder="Username" />
            </div>
            <div class="inputText">
                <span class="iconfont icon-visible"></span>
                <input type="password" placeholder="Password" />
            </div>
            <div class="inputText">
                <span class="iconfont icon-visible"></span>
                <input type="email" placeholder="enter your email" />
                <div>
                    <a href="/save" style="font-size: small;color: rgba(255, 255, 255, 0.699);margin-left: -20%;">发送验证码</a>
                </div>
            </div>
            <div class="inputText_code">
                <span class="iconfont icon-visible"></span>
                <input type="text" placeholder="enter your code" />
            </div>
            <input class="loginButton" type="submit" value="注册" />
        </form>
    </div>
</div>
</body>
</html>
