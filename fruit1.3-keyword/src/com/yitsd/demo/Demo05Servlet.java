package com.yitsd.demo;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName Demo05Servlet
 * @Date 2022/6/25 20:48
 * 演示session作用域
 */
@WebServlet("/demo05")
public class Demo05Servlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.像application作用域中保存数据
        //ServletContext:Servlet上下文
        ServletContext servletContext = request.getServletContext();
        servletContext.setAttribute("uname","lili");
        //2.客户端重定向
        response.sendRedirect("demo06");
        //3.服务器端转发
//        request.getRequestDispatcher("demo04").forward(request,response);
    }
}
