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
    <link rel="stylesheet" href="css/reg.css"/>
    <link rel="stylesheet" href="css/iconfont.css" />
    <link rel="stylesheet" href="css/youjian.css" />
    <title>注册</title>
    <script>
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
            request.open("POST", "/test", true);

            //想获取服务器传送过来的数据， 加一个状态的监听。
            request.onreadystatechange = function() {
                if (request.readyState == 4 && request.status == 200) {
                    alert("验证码发送成功");
                }
            }

            //如果使用的是post方式带数据，那么 这里要添加头， 说明提交的数据类型是一个经过url编码的form表单数据
            request.setRequestHeader("Content-type",
                "application/x-www-form-urlencoded");

            //带数据过去  ， 在send方法里面写表单数据。
            var email="email="+ document.getElementById("email").value;
            request.send(email);
        }
    </script>
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
                <span class="iconfont icon-youjian"></span>
                <input type="email" placeholder="enter your email" id="email" />
                <div>
                    <a onclick="javascript:post();return false" href="#" style="font-size: small;text-decoration:none;color: rgba(255, 255, 255, 0.699);margin-left: -20%;">发送验证码</a>
                </div>
            </div>
            <div class="inputText_code">
                <span class="iconfont icon-nickname"></span>
                <input type="text" placeholder="enter your code" />
            </div>
            <input class="loginButton" type="submit" value="注册" />
        </form>
    </div>
</div>
</body>
</html>
