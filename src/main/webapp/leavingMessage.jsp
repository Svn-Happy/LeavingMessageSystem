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
<html lang="en" class="no-js">
<head>
    <meta charset="utf-8">
    <link rel="icon" href="message.ico" type="image/x-icon">
    <link rel="stylesheet" type="text/css" href="css/留言.css">
    <script type="text/javascript" src="bootstrap-3.3.7-dist/js/jquery-1.8.3.min.js"></script>
    <title>留言站</title>
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

        function submit() {
            //1. 创建对象
            alert(0);
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
            var message="message="+ document.getElementById("msg").innerHTML;
            request.send(message);
            alert(0);
        }
        function  openwindow(str)
        {

            //获取父窗口的文本信息赋值给text
            // var text = ;
            //打开子窗口，并且把操作句柄赋值给win变量，以下所有操作都是针对win对象的
            var iTop = (window.screen.availHeight - 30 - 300) / 2;
            var iLeft = (window.screen.availWidth - 10 - 400) / 2;
            var m="menubar=no,width=400,height=300,resizeable=yes,"+"left="+iLeft/2+",top="+iTop/2;//解决位置问题

            var win = window.open("http://www.runoob.com","mywin", m);
            //输出基本信息
            win.document.writeln("<title>输出结果</title>");
            win.document.writeln("<><textarea rows='5' cols='51' >");
            //输出从父窗口获取的信息
            win.document.writeln("</textarea>");
            win.document.close();
            win.focus();
        }
    </script>
</head>
<body>
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
        <div class="content" contenteditable="true" name="text" id="msg">
        </div>
        <input type="button" value="发表" class="subbtn" onclick="submit()">
    <div class="numofmessage">留言(${size})</div>
    <!-- 下面是留言区 -->
    <div class="msgFrame">
        <div class="content_1">
            <img class="name" src="http://qlogo3.store.qq.com/qzone/1262283870/1262283870/100?1481718124" alt="头像">
            <div class="mainInfo">
                <div class="userId"><a href="#">${m.id}</a></div>
                <div class="conInfo">
                    ${m.message}
                </div>
                <div class="time">
                    ${m.date}&nbsp;&nbsp;&nbsp;
                    <a href="/delete?id=${m.num}">删除留言</a>
                    <a href="#" onclick="javascript:openwindow('http://baidu.com')">修改留言</a>
                </div>
            </div>
        </div>
      <c:forEach items="${message}" var="m">
          <div class="content_1">
              <img class="name" src="http://qlogo3.store.qq.com/qzone/1262283870/1262283870/100?1481718124" alt="头像">
              <div class="mainInfo">
                  <div class="userId"><a href="#">${m.id}</a></div>
                  <div class="conInfo">
                     ${m.message}
                  </div>
                  <div class="time">
                          ${m.date}&nbsp;&nbsp;&nbsp;
                              <a href="/delete?id=${m.num}">删除留言</a>
                              <a href="#" >修改留言</a>
                  </div>
              </div>
          </div>
      </c:forEach>
    </div>
</div>
<!-- classie.js by @desandro: https://github.com/desandro/classie -->
<script src="js/classie.js"></script>
<script src="js/modalEffects.js"></script>

<!-- for the blur effect -->
<!-- by @derSchepp https://github.com/Schepp/CSS-Filters-Polyfill -->
<script>
    // this is important for IEs
    var polyfilter_scriptpath = '/js/';
</script>
<script src="js/cssParser.js"></script>
<script src="js/css-filters-polyfill.js"></script>

</body>
</html>
