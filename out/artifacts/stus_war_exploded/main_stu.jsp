<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<frameset rows="50,*" scrolling="NO" frameborder="NO" border="0" framespacing="0">
    <frame src="font.jsp" tppabs="*" noresize="noresize" scrolling="NO"/>
    <frameset cols="150,*">
        <frame src="contents_stu.jsp" tppabs="*" noresize="noresize" scrolling="NO">
        <frame src="StuListServlet?user=${userBean.username}" tppabs="*" name="showframe">
    </frameset>
    <noframes></noframes>
</frameset>
</html>
