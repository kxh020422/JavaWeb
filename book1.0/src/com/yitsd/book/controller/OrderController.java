package com.yitsd.book.controller;

import com.yitsd.book.pojo.Book;
import com.yitsd.book.pojo.OrderBean;
import com.yitsd.book.pojo.OrderItem;
import com.yitsd.book.pojo.User;
import com.yitsd.book.service.BookService;
import com.yitsd.book.service.OrderService;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @ClassName OrderController
 * @Date 2022/7/7 18:24
 */
public class OrderController {

    private OrderService orderService;
    private BookService bookService;


    public String checkOut(HttpSession session) {

        OrderBean orderBean = new OrderBean();
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String nowStr = sdf.format(now);
        orderBean.setOrderNo(UUID.randomUUID().toString() + "_" + nowStr);
        orderBean.setOrderDate(now);
        User user = (User) session.getAttribute("currUser");
        orderBean.setOrderUser(user);
        orderBean.setOrderMoney(user.getCart().getTotalMoney());
        orderBean.setOrderStatus(0);

        orderService.addOrderBean(orderBean);
        return "index";
    }

    //查看订单列表
    public String getOrderList(HttpSession session){
        User user = (User) session.getAttribute("currUser");
        List<OrderBean> orderList = orderService.getOrderList(user);

        user.setOrderList(orderList);

        session.setAttribute("currUser",user);

        return "order/order";
    }

    //查看订单详情
    public String orderDetail(Integer orderBeanId,HttpSession session){
        List<OrderItem> orderDetailList = orderService.getOrderItemByOrderBeanId(orderBeanId);
        for (OrderItem orderItem : orderDetailList) {
            Book book = bookService.getBook(orderItem.getBook().getId());
            orderItem.setBook(book);
        }
        session.setAttribute("orderDetailList",orderDetailList);
        return "order/orderDetail";
    }

}
