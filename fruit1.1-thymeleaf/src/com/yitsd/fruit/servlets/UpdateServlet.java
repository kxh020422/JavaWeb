package com.yitsd.fruit.servlets;

import com.yitsd.fruit.dao.FruitDAO;
import com.yitsd.fruit.dao.impl.FruitDAOImpl;
import com.yitsd.fruit.pojo.Fruit;
import com.yitsd.myssm.myspringmvc.ViewBaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName UpdateServlet
 * @Date 2022/6/26 15:01
 */
@WebServlet("/update.do")
public class UpdateServlet extends ViewBaseServlet {

    private FruitDAO fruitDAO = new FruitDAOImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //设置编码
        request.setCharacterEncoding("utf-8");

        //获取参数
        int fid = Integer.parseInt(request.getParameter("fid"));
        String fname = request.getParameter("fname");
        String priceStr = request.getParameter("price");
        int price = Integer.parseInt(priceStr);
        String fcountStr = request.getParameter("fcount");
        int fcount = Integer.parseInt(fcountStr);
        String remark = request.getParameter("remark");

        //执行更新
        fruitDAO.updateFruit(new Fruit(fid, fname, price, fcount, remark));

        //资源跳转
//        super.processTemplate("index",request,response);

        //此处需要重定向，目的是重新给IndexServlet发送请求，重新获取fruitList,然后覆盖到session中
        response.sendRedirect("index");
    }
}
