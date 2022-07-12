package com.yitsd.servlets;

import com.yitsd.fruit.dao.FruitDAO;
import com.yitsd.fruit.dao.impl.FruitDAOImpl;
import com.yitsd.fruit.pojo.Fruit;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

public class AddServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        //post方式下 需要设置编码 防止中文乱码
        //设置编码必须放在获取参数的动作之前
        request.setCharacterEncoding("UTF-8");
        String fname = request.getParameter("fname");
        String priceStr = request.getParameter("price");
        Integer price = Integer.parseInt(priceStr);
        String fcountStr = request.getParameter("fcount");
        Integer fcount = Integer.parseInt(fcountStr);
        String remark = request.getParameter("remark");
        FruitDAO fruitDAO = new FruitDAOImpl();
        boolean flag = fruitDAO.addFruit(new Fruit(0 , fname , price , fcount , remark));
        System.out.println(flag ? "添加成功！" : "添加失败！");
    }
}
