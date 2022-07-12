package com.yitsd.book.service;

import com.yitsd.book.pojo.OrderBean;
import com.yitsd.book.pojo.OrderItem;
import com.yitsd.book.pojo.User;

import java.util.List;

public interface OrderService {

    void addOrderBean(OrderBean orderBean);

    List<OrderBean> getOrderList(User user);

    List<OrderItem> getOrderItemByOrderBeanId(Integer orderBeanId);
}
