package com.itheima.servlet;

import com.itheima.dao.StudentDao;
import com.itheima.dao.impl.StudentDaoImpl;
import com.itheima.domain.ClassTeaBean;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class UpdataTeaClassServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
        req.setCharacterEncoding("UTF-8");
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            String yi = req.getParameter("yi");
            String er = req.getParameter("er");
            String san = req.getParameter("san");
            String si = req.getParameter("si");
            String wu = req.getParameter("wu");

            ClassTeaBean classTeaBean = new ClassTeaBean();
            classTeaBean.setYi(yi);
            classTeaBean.setEr(er);
            classTeaBean.setSan(san);
            classTeaBean.setSi(si);
            classTeaBean.setWu(wu);

            StudentDao dao = new StudentDaoImpl();
            dao.updateTeaClass(classTeaBean);

            req.getRequestDispatcher("ClassTeaServlet").forward(req,resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
