<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>更新学生页面</title>
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>

</head>


<body>

<h3>更新学生页面</h3>
<center>
<form method="post" action="UpdateServlet">
	<input type="hidden" name="sid" value="${stu.sid }">
  <table border="1" width="1000" class="table table-bordered table-striped table-hover">
	  <tr>
		  <td>学号</td>
		  <td><input type="text" name="sno" value="${stu.sno}"></td>
	  </tr>
  <tr>
	<td>姓名</td>
	<td><input type="text" name="sname" value="${stu.sname }"></td>
  </tr>
  <tr>
	<td>性别</td>
	<td>
		<!-- 如果性别是男的，  可以在男的性别 input标签里面， 出现checked ,
		如果性别是男的，  可以在女的性别 input标签里面，出现checked -->
		<input type="radio" name="gender" value="男" <c:if test="${stu.gender == '男'}">checked</c:if>>男
		<input type="radio" name="gender" value="女" <c:if test="${stu.gender == '女'}">checked</c:if>>女
	</td>
  </tr>
  <tr>
	<td>电话</td>
	<td><input type="text" name="phone" value="${stu.phone }"></td>
  </tr>
  <tr>
	<td>生日</td>
	<td><input type="text" name="birthday" value="${stu.birthday }"></td>
  </tr>
  <tr>
	<td>班级</td>
	<td><input type="text" name="cs" value="${stu.cs}"></td>
	
	<%--<td>
		<!-- 爱好： 篮球 ， 足球 ， 看书
		因为爱好有很多个，  里面存在包含的关系 -->
		<input type="checkbox" name="hobby" value="游泳" <c:if test="${fn:contains(stu.hobby,'游泳') }">checked</c:if>>游泳
		<input type="checkbox" name="hobby" value="篮球" <c:if test="${fn:contains(stu.hobby,'篮球') }">checked</c:if>>篮球
		<input type="checkbox" name="hobby" value="足球" <c:if test="${fn:contains(stu.hobby,'足球') }">checked</c:if>>足球
		<input type="checkbox" name="hobby" value="看书" <c:if test="${fn:contains(stu.hobby,'看书') }">checked</c:if>>看书
		<input type="checkbox" name="hobby" value="写字" <c:if test="${fn:contains(stu.hobby,'写字') }">checked</c:if>>写字

	</td>--%>
  </tr>
  <tr>
	<td>年级</td>
	  <td><input type="text" name="grade" value="${stu.grade}"></td>
<%--	<td><textarea name="info" rows="3" cols="20">${stu.info }</textarea></td>--%>
  </tr>
  <tr>
	<td colspan="2"> <input type="submit" value="更新" class="btn btn-success"> </td>
  </tr>
  </table>
   </form>
</center>
</body>
</html>