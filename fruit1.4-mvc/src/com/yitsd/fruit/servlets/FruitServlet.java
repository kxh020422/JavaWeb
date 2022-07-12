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

/**
 * @ClassName FruitServlet
 * @Date 2022/6/27 15:08
 */

@WebServlet("/fruit.do")
public class FruitServlet extends ViewBaseServlet {
    private FruitDAO fruitDAO = new FruitDAOImpl();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        String operate = request.getParameter("operate");
        if (StringUtil.isEmpty(operate)) {
            operate = "index";
        }
        switch (operate) {
            case "index" -> index(request, response);
            case "add" -> add(request, response);
            case "del" -> del(request, response);
            case "edit" -> edit(request, response);
            case "update" -> update(request, response);
            default -> throw new IllegalStateException("Unexpected value: " + operate);
        }


    }


    private void index(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //设置编码

        //设置当前页 默认值是1
        int pageNo = 1;


        HttpSession session = request.getSession();

        String oper = request.getParameter("oper");
        //如果oper!=null 说明 通过表单的查询按钮点击过来的
        //如果oper==null 说明不是通过表单的查询按钮点击过来的


        String keyword = null;
        if (StringUtil.isNotEmpty(oper) && "search".equals(oper)) {
            //说明是点击表单查询发送过来的请求
            //此时 pageNo 应该还原为1 keyWord应该从请求参数中获取
            pageNo = 1;
            keyword = request.getParameter("keyword");
            //如果keyword为null，需要设置为空字符串""，否则模糊查询时会拼接为 "%null%" 我们期望的是 "%%"
            if (StringUtil.isEmpty(keyword)) {
                keyword = "";
            }
            //将keyword覆盖到session中
            session.setAttribute("keyword", keyword);
        } else {
            //说明是此处不是点击表单查询发送过来的请求（比如点击下面的上一页下一页或者直接在地址栏输入）
            //那么此时keyword应该从session作用域获取
            String pageNoStr = request.getParameter("pageNo");
            if (StringUtil.isNotEmpty(pageNoStr)) {
                pageNo = Integer.parseInt(pageNoStr);
            }

            //表示如果不是点击的查询按钮 那么查询是基于session中保存的现有的keyword进行查询
            Object keywordObj = session.getAttribute("keyword");
            if (keywordObj != null) {
                keyword = String.valueOf(keywordObj);
            } else {
                keyword = "";
            }
        }

        //重新更新当前页的值
        session.setAttribute("pageNo", pageNo);

        FruitDAO fruitDAO = new FruitDAOImpl();
        List<Fruit> fruitList = fruitDAO.getFruitList(keyword, pageNo);

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

    private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

        response.sendRedirect("fruit.do");
    }

    private void del(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fidStr = request.getParameter("fid");
        if (StringUtil.isNotEmpty(fidStr)) {
            int fid = Integer.parseInt(fidStr);
            fruitDAO.delFruit(fid);

            response.sendRedirect("fruit.do");
        }
    }

    private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fidStr = request.getParameter("fid");
        if (StringUtil.isNotEmpty(fidStr)) {
            int fid = Integer.parseInt(fidStr);
            Fruit fruit = fruitDAO.getFruitByFid(fid);
            request.setAttribute("fruit", fruit);
            super.processTemplate("edit", request, response);
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


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
        response.sendRedirect("fruit.do");
    }

}
