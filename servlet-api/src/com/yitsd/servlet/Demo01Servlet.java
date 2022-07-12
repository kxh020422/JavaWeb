package com.yitsd.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName Demo01
 * @Date 2022/6/28 20:58
 */
@WebServlet(urlPatterns = {"/demo01"},
        initParams = {
                @WebInitParam(name = "hello", value = "World"),
                @WebInitParam(name = "uname", value = "lili")
        })
public class Demo01Servlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        ServletConfig config = getServletConfig();
        String initValue = config.getInitParameter("hello");
        System.out.println("initValue = " + initValue);

        ServletContext servletContext = getServletContext();
        String contextConfigLocation = servletContext.getInitParameter("contextConfigLocation");
        System.out.println("contextConfigLocation = " + contextConfigLocation);

    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
