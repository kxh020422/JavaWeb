package com.yitsd.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName Demo02Servlet
 * @Date 2022/6/25 20:53
 * 演示request作用域
 */
@WebServlet("/demo02")
public class Demo02Servlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取request保存作用域保存的数据，key为uname
        Object unameObj = request.getAttribute("uname");
        System.out.println("unameObj = " + unameObj);

    }
}
