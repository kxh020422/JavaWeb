package com.yitsd.axios;

import com.google.gson.Gson;
import com.yitsd.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * @ClassName Axios02Servlet
 * @Date 2022/7/11 21:15
 */

@WebServlet("/axios02")
public class Axios02Servlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = request.getReader();
        String str;
        while ((str = bufferedReader.readLine()) != null) {
            stringBuilder.append(str);
        }

        str = stringBuilder.toString();
//        System.out.println("str = " + str);

        Gson gson = new Gson();
        User user = gson.fromJson(str, User.class);

        System.out.println(user);


        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

    }
}






