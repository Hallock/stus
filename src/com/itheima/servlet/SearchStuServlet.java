package com.itheima.servlet;

import com.itheima.domain.Student;
import com.itheima.service.StudentService;
import com.itheima.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Servlet implementation class SearchStudentServlet
 */
public class SearchStuServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8");
		try {

			//1. 取到了要查询的关键数据 姓名  ， 性别。
			String sname=  request.getParameter("user");
			String sgender=  request.getParameter("sgender");
			System.out.println(sname);
			//2. 找service去查询
			StudentService service = new StudentServiceImpl();
			List<Student> list = service.searchStudent(sname, sgender);

			request.setAttribute("list", list);
			
			//3. 跳转界面。列表界面
			request.getRequestDispatcher("list.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
