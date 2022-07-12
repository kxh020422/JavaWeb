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
 * @ClassName AddServlet
 * @Date 2022/6/26 16:22
 */
@WebServlet("/add.do")
public class AddServlet extends ViewBaseServlet {

    private FruitDAO fruitDAO = new FruitDAOImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");

        //获取参数
        String fname = request.getParameter("fname");
        String priceStr = request.getParameter("price");
        int price = Integer.parseInt(priceStr);
        String fcountStr = request.getParameter("fcount");
        int fcount = Integer.parseInt(fcountStr);
        String remark = request.getParameter("remark");

        fruitDAO.addFruit(new Fruit(0, fname, price, fcount, remark));

        response.sendRedirect("index");
    }
}
