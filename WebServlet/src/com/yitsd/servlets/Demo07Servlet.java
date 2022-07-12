package com.yitsd.servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName Demo07Servlet
 * @Date 2022/6/25 15:32
 */
public class Demo07Servlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("demo07......");
    }
}
