package com.yitsd.demo;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName Demo06Servlet
 * @Date 2022/6/25 20:53
 * 演示session作用域
 */
@WebServlet("/demo06")
public class Demo06Servlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) {
        //获取session保存作用域保存的数据，key为uname
        ServletContext servletContext = request.getServletContext();
        Object unameObj = servletContext.getAttribute("uname");
        System.out.println("unameObj = " + unameObj);
    }
}
