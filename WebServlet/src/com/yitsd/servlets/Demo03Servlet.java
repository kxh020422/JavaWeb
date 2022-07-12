package com.yitsd.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @ClassName Demo03Servlet
 * @Date 2022/6/25 13:23
 * 演示Session
 */
public class Demo03Servlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取Session 如果获取不到 则创建一个新的
        HttpSession session = request.getSession();
        System.out.println("session ID = " + session.getId());
    }
}
