<%--
  Created by IntelliJ IDEA.
  User: 73439
  Date: 2021/1/10
  Time: 9:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>修改</title>
    <link rel="stylesheet" href="css/update.css"/>
</head>
<body style="background-image: url('img/update.png');background-size: 100%">
<div id="bigBox">
    <h1>update</h1>
    <form action="/update?id=${id}" method="get">
        <div class="inputBox">
            <div class="inputText">
                <textarea rows="10" cols="20" placeholder="请输入内容">${message}</textarea>
            </div>
        </div>
        <input class="loginButton" type="submit" value="提交" />
    </form>
</div>

</body>
</html>
