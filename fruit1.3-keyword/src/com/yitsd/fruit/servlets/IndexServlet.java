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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        int pageNo = 1;
        HttpSession session = request.getSession();

        String oper = request.getParameter("oper");
        //如果oper!=null 说明 通过表单的查询按钮点击过来的
        //如果oper==null 说明不是通过表单的查询按钮点击过来的


        String keyword = null;
        if (StringUtil.isNotEmpty(oper) && "search".equals(oper)){
            //说明是点击表单查询发送过来的请求
            //此时 pageNo 应该还原为1 keyWord应该从请求参数中获取
            pageNo = 1;
            keyword = request.getParameter("keyword");
            if (StringUtil.isEmpty(keyword)){
                keyword = "";
            }
            session.setAttribute("keyword",keyword);
        } else {
            //说明是此处不是点击表单查询发送过来的请求（比如点击下面的上一页下一页或者直接在地址栏输入）
            //那么此时keyword应该从session作用域获取
            String pageNoStr = request.getParameter("pageNo");
            if (StringUtil.isNotEmpty(pageNoStr)) {
                pageNo = Integer.parseInt(pageNoStr);
            }
            Object keywordObj = session.getAttribute("keyword");
            if (keywordObj != null){
                keyword = String.valueOf(keywordObj);
            } else {
                keyword = "";
            }
        }


        session.setAttribute("pageNo", pageNo);

        FruitDAO fruitDAO = new FruitDAOImpl();
        List<Fruit> fruitList = fruitDAO.getFruitList(keyword,pageNo);

        int fruitCount = fruitDAO.getFruitCount(keyword);
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
