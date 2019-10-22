<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生列表页面</title>
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>

<script type="text/javascript">

	function doDelete(sid) {
		/* 如果这里弹出的对话框，用户点击的是确定，就马上去请求Servlet。
		如何知道用户点击的是确定。
		如何在js的方法中请求servlet。 */
		var flag = confirm("是否确定删除?");
		if(flag){
			//表明点了确定。 访问servlet。 在当前标签页上打开 超链接，
			//window.location.href="DeleteServlet?sid="+sid;
			location.href="DeleteServlet?sid="+sid;
		}
	}
</script>

</head>
<body>
<div class="container-fluid">
<center>

	<form action="SearchStudentServlet" method="post">
		<div class="col-md-12">
		<table width="100%" class="table table-bordered table-striped table-hover">

			<tr >

				<td colspan="9" align="center">

					按姓名查询:<input type="text" name="sname" />
					&nbsp;
					按性别查询:<select name="sgender" >
								<option value="">--请选择--
								<option value="男">男
								<option value="女">女
							  </select>
					&nbsp;&nbsp;&nbsp;
					<input class="btn btn-primary" type="submit" value="查询">

				</td>

			</tr>

		  <tr align="center">
			<td>编号</td>
		    <td>学号</td>
			<td>姓名</td>
			<td>性别</td>
			<td>联系方式</td>
			<td>出生年月</td>
			<td>班级</td>
			<td>年级</td>
			<td>操作</td>
		  </tr>

			  <c:forEach items="${pageBean.list }" var="stu">
				  <tr align="center">
					<td>${stu.sid }</td>
					  <td>${stu.sno}</td>
					<td>${stu.sname }</td>
					<td>${stu.gender }</td>
					<td>${stu.phone }</td>
					<td>${stu.birthday }</td>
					<td>${stu.cs }</td>
					<td>${stu.grade }</td>
					<td><a class="btn bg-success" href="EditServlet?sid=${stu.sid }">更新</a>  </td>
				  </tr>
			  </c:forEach>

			  <tr>
			  	<td colspan="9" align="center">
			  		第 ${pageBean.currentPage } / ${pageBean.totalPage }
			  		&nbsp;&nbsp;
			  		每页显示${pageBean.pageSize }条  &nbsp;&nbsp;&nbsp;
			  		总的记录数${pageBean.totalSize } &nbsp;&nbsp;&nbsp;
			  		<c:if test="${pageBean.currentPage !=1 }">
			  			<a href="StudentListPageServlet?currentPage=1">首页</a>
						| <a href="StudentListPageServlet?currentPage=${pageBean.currentPage-1}&type=${userBean.type}">上一页</a>
			  		</c:if>

			  		<c:forEach begin="1" end="${pageBean.totalPage }" var="i">
			  			<c:if test="${pageBean.currentPage == i }">
			  				${i }
			  			</c:if>
			  			<c:if test="${pageBean.currentPage != i }">
			  				<a href="StudentListPageServlet?currentPage=${i }">${i }</a>
			  			</c:if>

			  		</c:forEach>


			  		<c:if test="${pageBean.currentPage !=pageBean.totalPage }">
			  			<a href="StudentListPageServlet?currentPage=${pageBean.currentPage+1}&type=${userBean.type}">下一页</a> |
			  			<a href="StudentListPageServlet?currentPage=${pageBean.totalPage }">尾页</a>
			  		</c:if>
			  	</td>
			  </tr>
		  </table>
		</div>
	  </form>

</center>
</div>
</body>
</html>