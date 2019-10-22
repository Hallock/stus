package com.itheima.servlet;

import com.itheima.dao.StudentDao;
import com.itheima.dao.impl.StudentDaoImpl;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class checkUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {

            request.setCharacterEncoding("UTF-8");

            //1. 检测是否存在
            String username = request.getParameter("name");
            System.out.println("name="+username);

            StudentDao dao = new StudentDaoImpl();
            boolean isExist = dao.checkUserName(username);

            //2.  通知页面，到底有还是没有。
            if(isExist){
                response.getWriter().println(1);  //存在用户名
            }else{
                response.getWriter().println(2); //不存在该用户名
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
