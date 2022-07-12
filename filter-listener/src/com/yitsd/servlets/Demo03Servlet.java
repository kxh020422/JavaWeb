package com.yitsd.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName Demo01Servlet
 * @Date 2022/6/29 17:11
 */

@WebServlet("/demo03.do")
public class Demo03Servlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("demo03Service......");
        request.getRequestDispatcher("succ.html").forward(request, response);
    }
}
