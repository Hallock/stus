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
<form method="post" action="UpdateCardServlet">
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
	<td>语文</td>
	<td><input type="text" name="ch" value="${stu.ch}"></td>
  </tr>
  <tr>
	<td>英语</td>
	<td><input type="text" name="en" value="${stu.en }"></td>
  </tr>
  <tr>
	<td>数学</td>
	<td><input type="text" name="math" value="${stu.math }"></td>
  </tr>
  <tr>
	<td>物理</td>
	<td><input type="text" name="physics" value="${stu.physics}"></td>
  </tr>
  <tr>
	<td>化学</td>
	  <td><input type="text" name="chemistry" value="${stu.chemistry}"></td>
  </tr>
  <tr>
	<td colspan="2"> <input type="submit" value="更新" class="btn btn-success"> </td>
  </tr>
  </table>
   </form>
</center>
</body>
</html>