<%--
  Created by IntelliJ IDEA.
  User: 73439
  Date: 2021/1/4
  Time: 17:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <title>留言站</title>
    <link rel="icon" sizes="any" mask href="http://qzonestyle.gtimg.cn/qzone/v8/img/Qzone.svg">
    <link rel="stylesheet" type="text/css" href="../css/留言.css">
    <link href="bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <script src="bootstrap-3.3.7-dist/js/jquery1.4.js"></script>
</head>
<body>
<div class="header">
    This is the head nav
</div>
<div class="topInfo">
    <span class="edit">编辑</span>
    <div class="zoneName">
        <h2>欢迎你${name}</h2>   <!--将使用者的姓名传过来-->
        <p>个人签名</p>
    </div>
    <div class="tips">7人赞过</div>
    <!-- bottom nav -->
    <div class="top_bottom">
        <div class="photo">
            <img src="http://qlogo3.store.qq.com/qzone/1262283870/1262283870/100?1481718124">
        </div>
        <div class="uploadphoto">修改头像</div>
        <div class="container">
            <ul class="section">
                <li>主页</li>
                <li>日志</li>
                <li>相册</li>
                <li>留言板</li>
                <li>说说</li>
                <li>个人档</li>
                <li>音乐</li>
                <li>更多</li>
            </ul>
        </div>
    </div>
</div>
<!-- 下面实现留言板功能 -->
<div class="mainframe">
    <div class="title">留言板</div>
    <div class="message">主人寄语</div>
    <div class="info">
        这是主人留下的寄语~
    </div>
    <div class="content" contenteditable="true"></div>
    <input type="button" name="submit" value="发表" class="subbtn">
    <div class="numofmessage">留言(0)</div>
    <!-- 下面是留言区 -->
    <div class="msgFrame">
      <c:forEach items="${message}" var="m">
          <div class="content_1">
              <img class="name" src="http://qlogo3.store.qq.com/qzone/1262283870/1262283870/100?1481718124" alt="头像">
              <div class="mainInfo">
                  <div class="userId"><a href="#">${name}</a></div>
                  <div class="conInfo">
                     ${m.message}
                  </div>
                  <div class="time">${m.time}</div>
              </div>
          </div>
      </c:forEach>
    </div>
</div>
</body>
</html>
