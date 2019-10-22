package com.itheima.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import org.apache.catalina.valves.StuckThreadDetectionValve;

import com.itheima.domain.PageBean;
import com.itheima.service.StudentService;
import com.itheima.service.impl.StudentServiceImpl;


/**
 * 这是用于分页显示学生列表的servlet
 * @author xiaomi
 *
 */
public class StudentListPageServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try {
			//1. 获取需要显示的页码数
			int currentPage =Integer.parseInt( request.getParameter("currentPage"));
			int type =Integer.parseInt( request.getParameter("type"));
			System.out.println("type="+type);
			StudentService service = new StudentServiceImpl();
			PageBean pageBean= service.findStudentByPage(currentPage);
			request.setAttribute("pageBean", pageBean);
			//3. 跳转界面。
			if (type==2){
				request.getRequestDispatcher("list_tea.jsp").forward(request, response);
			}else {
				request.getRequestDispatcher("list_page.jsp").forward(request, response);
			}


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
