package com.itheima.servlet;

import com.itheima.domain.PageBean;
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
 * 负责查询所有的学生信息。 然后呈现到list.jsp页面上。
 */
public class cardListServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		try {
		
//			//1. 查询出来所有的学生
//			StudentService service = new StudentServiceImpl();
//			List<Student> list = service.findAll();
//
//			//2. 先把数据存储到作用域中
//			request.setAttribute("list", list);
//			//3. 跳转页面

			int currentPage =Integer.parseInt( request.getParameter("currentPage"));

			//2. 根据指定的页数，去获取该页的数据回来
			//List<Student> --- list.jsp

			StudentService service = new StudentServiceImpl();
			PageBean pageBean= service.findStudentByPage(currentPage);
			request.setAttribute("pageBean", pageBean);



			request.getRequestDispatcher("card.jsp").forward(request, response);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
