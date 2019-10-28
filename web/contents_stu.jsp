<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<script src="http://use.edgefonts.net/allan:n7:default.js" type="text/javascript"></script>
<style type="text/css">


    body {
        font-family: "楷体";
        font-style: normal;
        font-weight: 700;
        font-size: 18px;
        margin-bottom: 0rem;
        margin-top: 0rem;
        margin-left: 0rem;
        background-color: #0389db;
    }

    #div01 {
        width: 6.25rem;
        background-color: #0389db;
    }

    ul {
        list-style-type: none;
        margin: 0;
        padding: 0;
        width: 170px;
        background-color: #0389db;
        text-align: center;
    }

    li a {
        display: block;
        color: white;
        padding: 8px 16px;
        text-decoration: none;
    }

    li a:hover {
        background-color: #555;
        color: white;
    }

    p {
        padding-top: 0.5rem;
        width: 10.625rem;
        font-size: 1.5rem;
        margin-bottom: 0rem;
        margin-top: 0rem;
        color: white;
        background-color: #39aef5;
    }
</style>
<body>
<div id="div01">
    <p>管理</p>
    <ul>
        <li><a href="StuListServlet?user=${userBean.username}" tppabs="*" target="showframe">我的成绩</a></li>
        <li><a href="ClassTeaServlet" tppabs="*" target="showframe">我的课程</a></li>
    </ul>

</div>
</body>
</html>
