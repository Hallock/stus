package com.itheima.servlet;

import com.itheima.domain.Student;
import com.itheima.service.StudentService;
import com.itheima.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Servlet implementation class UpdateServlet
 */
public class UpdateCardServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8");
		try {
			//1. 获取客户端提交上来的数据
			int sid = Integer.parseInt(request.getParameter("sid"));
			int sno = Integer.parseInt(request.getParameter("sno"));
			String sname = request.getParameter("sname"); //sname:zhangsan
			int ch = Integer.parseInt(request.getParameter("ch"));
			int en = Integer.parseInt(request.getParameter("en"));
			int math = Integer.parseInt(request.getParameter("math")); // 1989-10-18
			int physics = Integer.parseInt(request.getParameter("physics"));
			int chemistry = Integer.parseInt(request.getParameter("chemistry"));
			//String hobby = request.getParameter("hobby");//hobby : 游泳，写字， 足球。
//			String[] h = request.getParameterValues("hobby");
//			//		[篮球，足球，写字] --- 篮球，足球，写字
//			String hobby = Arrays.toString(h);
//			hobby = hobby.substring(1, hobby.length() - 1);
			//2. 添加到数据库
			//string -- date
			//Date date = new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
			Student student = new Student(sid,sno ,sname, ch, en,math, physics, chemistry);
			
			//2. 更新数据库数据
			StudentService service = new StudentServiceImpl();
			service.updateCard(student);
			
			//3. 跳转界面
			request.getRequestDispatcher("cardListServlet?currentPage=1").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
