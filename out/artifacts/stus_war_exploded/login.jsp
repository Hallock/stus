<%--
  Created by IntelliJ IDEA.
  User: Hallock
  Date: 2019/9/17
  Time: 16:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8"/>
    <title>文章管理系统</title>
    <link rel="stylesheet" type="text/css" href="css/login.css"/>

</head>
<body id="body">
<form action="loginServlet" method="post">
    <center>
        <h1 id="h1_name">学生管理系统</h1>
        <div id="div01">
            <div id="font">
                <span>登录</span>
            </div>
            <select name="selectUser">
                <option value="" >---请选择用户---</option>
                <option value="1">管理员</option>
                <option value="3">学生</option>
                <option value="2">老师</option>
            </select>
            <input type="text" name="name" placeholder="用户名/邮箱"/><br/>
            <input type="password" name="password" placeholder="密码"/><br/>
            <input type="text" name="verifycode" id="code_input" placeholder="验证码"/><span id="span1"></span><br/>
            <div id="v_container" style="width: 150px;height: 40px;"></div>
            <input type="submit" id="submit1" value="登录" disabled class="btn btn-info"/><br/>

            <script type="text/javascript" src="js/gVerify.js"></script>
            <script type="text/javascript" src="js/jquery.min.js"></script>
            <script type="text/javascript">
                var verifyCode = new GVerify("v_container");
                document.getElementById("code_input").onblur = function () {
                    var res = verifyCode.validate(document.getElementById("code_input").value);

                    if (res) {
                        //alert("验证码正确");
                        $("#span1").html("<font color='green'>验证码正确</font>")
                        $("#submit1").removeAttr("disabled")
                    } else {
                        //alert("验证码错误");
                        $("#span1").html("<font color='red'>验证码错误</font>")
                    }
                }

            </script>
            <a href="#">忘记密码</a>
        </div>
    </center>
</form>
</body>
</html>

