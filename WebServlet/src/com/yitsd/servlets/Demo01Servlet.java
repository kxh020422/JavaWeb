package com.yitsd.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName Demo01Servlet
 * @Date 2022/6/24 20:35
 */
public class Demo01Servlet extends HttpServlet {
   @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       super.doPost(request, response);
   }

}
