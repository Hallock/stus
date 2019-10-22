<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title></title>
    <link rel="stylesheet" href="css/bootstrap.min.css"/>
    <style type="text/css">
        #body {
            background: #276fb9;
            margin-bottom: 0rem;
            margin-top: 0rem;
        }

        #sp01 {
            font-size: 3rem;
            color: white;
        }

        .col-md-2 {
            margin-top: 0.625rem;
        }
    </style>
</head>
<body id="body">
<div class="container-fluid">
    <div class="col-md-10">
        <span id="sp01">学生管理系统</span>
    </div>
    <div class="col-md-2 text-right">
        <span name="user" style="font-weight: bold">${userBean.username}&nbsp;</span>
        <a href="#" class="btn btn-default" role="button">退出</a>
    </div>
</div>
</body>
</html>
