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
public class UpdateAdminServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8");
		try {

			//1. 获取客户端提交上来的数据
			int sid = Integer.parseInt(request.getParameter("sid"));
			int sno = Integer.parseInt(request.getParameter("sno"));
			String sname = request.getParameter("sname"); //sname:zhangsan
			String gender = request.getParameter("gender");
			String phone = request.getParameter("phone");
			String birthday = request.getParameter("birthday"); // 1989-10-18
			String cs = request.getParameter("cs");
			String grade = request.getParameter("grade");
			Date date = new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
			Student student = new Student(sid,sno ,sname, gender, phone,cs, grade, date);
			
			//2. 更新数据库数据
			StudentService service = new StudentServiceImpl();
			service.update(student);
			
			//3. 跳转界面
			request.getRequestDispatcher("StudentListPageServlet?currentPage=1&type=0").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
