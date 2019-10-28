<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/10/23 0023
  Time: 12:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <link rel="stylesheet" href="css/bootstrap.min.css" />
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>

</head>
<body>
<div class="container-fluid">
    <div class="col-md-12">
        <form action="ClassStuServlet" method="post">
            <table width="1000" class="table table-bordered table-striped table-hover text-center">
                <tr >
                    <td></td>
                    <td>星期一</td>
                    <td>星期二</td>
                    <td>星期三</td>
                    <td>星期四</td>
                    <td>星期五</td>

                </tr>
                <c:forEach items="${list}" var="tea" >
                    <tr>
                        <td>${tea.type}</td>
                        <td>${tea.yi} </td>
                        <td>${tea.er} </td>
                        <td>${tea.san} </td>
                        <td>${tea.si}</td>
                        <td>${tea.wu} </td>
                    </tr>
                </c:forEach>
            </table>
        </form>
    </div>
</div>
</body>
</html>
