<%--
  Created by IntelliJ IDEA.
  User: 73439
  Date: 2021/1/4
  Time: 16:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/reg.css"/>
    <link rel="stylesheet" href="css/iconfont.css" />
    <link rel="stylesheet" href="css/youjian.css" />
    <link rel="icon" href="star.ico" type="image/x-icon">
    <script src="bootstrap-3.3.7-dist/js/jquery1.4.js"></script>
    <title>注册</title>
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
        function ajaxFunction() {
            var xmlHttp;
            try { // Firefox, Opera 8.0+, Safari
                xmlHttp = new XMLHttpRequest();
            } catch (e) {
                try {// Internet Explorer
                    xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
                } catch (e) {
                    try {
                        xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
                    } catch (e) {
                    }
                }
            }
            return xmlHttp;
        }
        function post() {
            //1. 创建对象
            var request = ajaxFunction();

            //2. 发送请求
            request.open("POST", "/vcode", true);

            //想获取服务器传送过来的数据， 加一个状态的监听。
            request.onreadystatechange = function() {
                if (request.readyState == 4 && request.status == 200) {
                    alert("验证码发送成功");
                }
            }

            //如果使用的是post方式带数据，那么 这里要添加头， 说明提交的数据类型是一个经过url编码的form表单数据
            request.setRequestHeader("Content-type",
                "application/x-www-form-urlencoded");
            var email=document.getElementById("email").value;
            if(email == null || email ==="")
                alert("邮箱不能为空");
            else{
                var email="email="+ document.getElementById("email").value;
                //带数据过去  ， 在send方法里面写表单数据。
                request.send(email);
            }
        }
    </script>
</head>
<body>
<video id="v1" autoplay loop muted>
    <source src="img/girl.mp4" type="video/mp4"  />
</video>
<div id="bigBox">
    <h1>Create Account</h1>
    <div class="inputBox">
        <form action="/reg" method="post">
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
            <div class="inputText">
                <span class="iconfont icon-youjian"></span>
                <input type="email" name="email" placeholder="enter your email" id="email" />
                <div>
                    <a onclick="javascript:post();return false" href="#" style="font-size: small;text-decoration:none;color: rgba(255,255,255,0.7);margin-left: -20%;">发送验证码</a>
                </div>
            </div>
            <div class="inputText_code">
                <span class="iconfont icon-nickname"></span>
                <input type="text" name="uservcode" placeholder="enter your code" />
            </div>
            <input class="loginButton" type="submit" value="注册" />
        </form>
    </div>
</div>
</body>
</html>
