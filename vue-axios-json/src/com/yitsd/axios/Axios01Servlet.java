package com.yitsd.axios;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @ClassName Axios01Servlet
 * @Date 2022/7/11 20:19
 */

@WebServlet("/axios01")
public class Axios01Servlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        String uname = request.getParameter("uname");
        String pwd = request.getParameter("pwd");

        System.out.println("uname = " + uname);

        System.out.println("pwd = " + pwd);

        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.write(uname + "_" + pwd);

    }
}
