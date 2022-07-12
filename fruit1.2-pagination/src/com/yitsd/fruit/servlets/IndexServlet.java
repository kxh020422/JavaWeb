package com.yitsd.fruit.servlets;


import com.yitsd.fruit.dao.FruitDAO;
import com.yitsd.fruit.dao.impl.FruitDAOImpl;
import com.yitsd.fruit.pojo.Fruit;
import com.yitsd.myssm.myspringmvc.ViewBaseServlet;
import com.yitsd.myssm.util.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

//Servlet从3.0版本开始支持注解方式的注册
@WebServlet("/index")
public class IndexServlet extends ViewBaseServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int pageNo = 1;
        String pageNoStr = request.getParameter("pageNo");
        if (StringUtil.isNotEmpty(pageNoStr)) {
            pageNo = Integer.parseInt(pageNoStr);
        }

        HttpSession session = request.getSession();
        session.setAttribute("pageNo", pageNo);

        FruitDAO fruitDAO = new FruitDAOImpl();
        List<Fruit> fruitList = fruitDAO.getFruitList(pageNo);

        int fruitCount = fruitDAO.getFruitCount();
        int pageCount = (fruitCount + 5 - 1) / 5;


        //保存到session作用域
        session.setAttribute("fruitList", fruitList);
        session.setAttribute("pageCount", pageCount);

        //此处的视图名称是index
        //那么thymeleaf会将这个 逻辑视图名称 对应到 物理视图 名称上去
        //逻辑视图名称：index
        //物理视图名称：view-prefix + 逻辑视图名称 + view—suffix
        //所以真实的视图名称是 ： /      index       .html
        super.processTemplate("index", request, response);
    }
}
