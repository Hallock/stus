package com.itheima.servlet;




import com.itheima.dao.StudentDao;
import com.itheima.dao.impl.StudentDaoImpl;
import com.itheima.domain.Student;
import com.itheima.domain.UserBean;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class loginServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置响应内容类型
//        resp.setContentType("text/html");

//        //设置逻辑实现
////        PrintWriter out = resp.getWriter();
////        out.println("<h1>" + message + "</h1>");

//        String password = req.getParameter("password");
//        String verifycode = req.getParameter("verifycode");

        try {
            req.setCharacterEncoding("UTF-8");
            String userName = req.getParameter("name");
            String password = req.getParameter("password");
            int selectUser = Integer.parseInt(req.getParameter("selectUser"));
            System.out.println("name=" + userName+"password"+password+"SelectUser"+selectUser);

            UserBean user = new UserBean();
            user.setUsername(userName);
            user.setType(selectUser);
            user.setPassword(password);

            StudentDao dao = new StudentDaoImpl();
            UserBean student = dao.login(user);
            System.out.println(student);
            if (selectUser==1){
                if (student != null) {
                    //成功了，进入首页
                    req.getSession().setAttribute("userBean", student);
                    resp.sendRedirect("main.jsp");
                } else {
                    //不成功...
                    resp.sendRedirect("login.jsp");
//                req.getRequestDispatcher("jsp/login.jsp").forward(req, resp);
                }
            }else if (selectUser==3){
                if (student != null) {
                    //成功了，进入首页
                    req.getSession().setAttribute("userBean", student);
                    resp.sendRedirect("main_stu.jsp");
                } else {
                    //不成功...
                    resp.sendRedirect("login.jsp");
//                req.getRequestDispatcher("jsp/login.jsp").forward(req, resp);
                }
            }else {
                if (student != null) {
                    //成功了，进入首页
                    req.getSession().setAttribute("userBean", student);
                    resp.sendRedirect("main_tea.jsp");
                } else {
                    //不成功...
                    resp.sendRedirect("login.jsp");
//                req.getRequestDispatcher("jsp/login.jsp").forward(req, resp);
                }
            }



        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    public void destroy() {
        super.destroy();
    }

}
