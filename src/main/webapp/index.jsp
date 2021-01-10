<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="tree.ico" type="image/x-icon">
    <link rel="stylesheet" href="css/login.css"/>
    <link rel="stylesheet" href="css/iconfont.css" />
    <script src="bootstrap-3.3.7-dist/js/jquery1.4.js"></script>
    <title>登录</title>
    <script>
        function checkUsername(){
            var p1=$("#p1").val();
            if(p1==null||p1==="")
                alert("账号不能为空!!!");
        }
        function checkPassword(){
            var p2=$("#p2").val();
            if(p2==null||p2==="")
                alert("密码不能为空!!!");
        }
    </script>
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
                    <input type="text" name="username" id="p1" placeholder="Username" onblur="checkUsername()"/>
                    <div>
                        <font style="font-size: smaller;color: rgba(255,255,255,0.7);margin-left: -20%;">${warning}</font>
                    </div>
                </div>
                <div class="inputText">
                    <span class="iconfont icon-visible"></span>
                    <input type="password" name="password" id="p2" placeholder="Password" onblur="checkPassword()"/>
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
