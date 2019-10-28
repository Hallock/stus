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
    <script type="text/javascript">
    function infoID() {
        var tableRow = $("#info")[0].parentElement.parentElement;
        var cl = tableRow.cells[2].innerText;
        var message = tableRow.cells[6].innerText;
        alert(cl+message)
    }
    </script>

</head>
<body>
<div class="container-fluid">
    <div class="col-md-12">
        <form action="ClassTeaServlet" method="post">
        <table width="1000" class="table table-bordered table-striped table-hover text-center">
        <tr >
            <td></td>
            <td>星期一</td>
            <td>星期二</td>
            <td>星期三</td>
            <td>星期四</td>
            <td>星期五</td>
            <td></td>
        </tr>
            <c:forEach items="${list}" var="tea" >
        <tr>
            <td  id="info">${tea.type}</td>
            <td>${tea.yi} </td>
            <td>${tea.er} </td>
            <td>${tea.san} </td>
            <td>${tea.si}</td>
            <td>${tea.wu} </td>
            <td> <a href="#myModal" data-toggle="modal" data-target="#myModal" onclick="infoID()">修改</a></td>
            <td hidden>${tea.id}</td>
        </tr>
            </c:forEach>
        </table>
        </form>
    </div>



    <!-- 模态框（Modal） -->
    <div class="modal fade sm" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-lg">
            <div class="modal-content" >
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title" id="myModalLabel">修改课程：</h4>
                </div>
                <form action="UpdataTeaClassServlet" method="post">
                <div class="modal-body">
                    <table width="100%" class="text-center" >
                        <tr>
                            <td>星期一</td>
                            <td>星期二</td>
                            <td>星期三</td>
                            <td>星期四</td>
                            <td>星期五</td>
                        </tr>
                        <tr>
                            <td><input type="text" name="yi" class="form-control"></td>
                            <td><input type="text" name="er" class="form-control"></td>
                            <td><input type="text" name="san" class="form-control"></td>
                            <td><input type="text" name="si" class="form-control"></td>
                            <td><input type="text" name="wu" class="form-control"></td>
                        </tr>
                    </table>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="submit" class="btn btn-primary">提交更改</button>
                </div>
                </form>
            </div><!-- /.modal-content -->
        </div><!-- /.modal -->
    </div>
</div>
</body>
</html>
