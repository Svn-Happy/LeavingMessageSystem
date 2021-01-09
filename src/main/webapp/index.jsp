<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="tree.ico" type="image/x-icon">
    <link rel="stylesheet" href="css/login.css"/>
    <link rel="stylesheet" href="css/iconfont.css" />
    <title>登录</title>
</head>
<body>
    <video id="v1" autoplay loop muted>
        <source src="img/girl.mp4" type="video/mp4"  />
    </video>
    <div id="bigBox">
        <form action="/login" method="post">
            <h1>LOGIN</h1>
            <div class="inputBox">
                <div class="inputText">
                    <span class="iconfont icon-nickname"></span>
                    <input type="text" name="username" placeholder="Username" />
                </div>
                <div class="inputText">
                    <span class="iconfont icon-visible"></span>
                    <input type="password" name="password" placeholder="Password" />
                </div>
            </div>
            <input class="loginButton" type="submit" value="登录" />
        </form>
        <div class="reghref">
            <a href="register.jsp"  style="color:rgba(255, 255, 255, 0.699);text-decoration:none;">去注册</a>
        </div>
    </div>
</body>
</html>
