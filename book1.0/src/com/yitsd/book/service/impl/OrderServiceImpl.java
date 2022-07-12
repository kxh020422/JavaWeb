package com.yitsd.book.service.impl;

import com.yitsd.book.dao.CartItemDAO;
import com.yitsd.book.dao.OrderDAO;
import com.yitsd.book.dao.OrderItemDAO;
import com.yitsd.book.pojo.CartItem;
import com.yitsd.book.pojo.OrderBean;
import com.yitsd.book.pojo.OrderItem;
import com.yitsd.book.pojo.User;
import com.yitsd.book.service.OrderService;

import java.util.List;
import java.util.Map;

/**
 * @ClassName OrderServiceImpl
 * @Date 2022/7/7 18:06
 */
public class OrderServiceImpl implements OrderService {

    private OrderDAO orderDAO;
    private OrderItemDAO orderItemDAO;
    private CartItemDAO cartItemDAO;
    private Integer getOrderTotalBookCount;

    @Override
    public void addOrderBean(OrderBean orderBean) {
        //1.订单表添加一条记录
        orderDAO.addOrderBean(orderBean);//执行完这一步orderBean中的id是有值的
        //2.订单详情表添加n条记录
        User currUser = orderBean.getOrderUser();
        Map<Integer, CartItem> cartItemMap = currUser.getCart().getCartItemMap();
        for (CartItem cartItem : cartItemMap.values()) {
            OrderItem orderItem = new OrderItem();
            orderItem.setBook(cartItem.getBook());
            orderItem.setBuyCount(cartItem.getBuyCount());
            orderItem.setOrderBean(orderBean);
            orderItemDAO.addOrderItem(orderItem);
        }
        //3.购物车项表中需要删除对应的n条记录
        for (CartItem cartItem : cartItemMap.values()) {
            cartItemDAO.delCartItem(cartItem);
        }
    }

    @Override
    public List<OrderBean> getOrderList(User user) {
        List<OrderBean> orderBeanList = orderDAO.getOrderList(user);

        for (OrderBean orderBean : orderBeanList) {
            Integer totalBookCount = orderDAO.getOrderTotalBookCount(orderBean);
            orderBean.setTotalBookCount(totalBookCount);
        }

        return orderBeanList;
    }

    @Override
    public List<OrderItem> getOrderItemByOrderBeanId(Integer orderBeanId) {
        return orderItemDAO.getOrderItemByOrderBeanId(orderBeanId);
    }
}
