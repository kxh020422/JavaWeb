package com.yitsd.book.dao;

import com.yitsd.book.pojo.OrderItem;

import java.util.List;

public interface OrderItemDAO {
    //添加订单项
    void addOrderItem(OrderItem orderItem);


    //根据订单id查询订单详情
    List<OrderItem> getOrderItemByOrderBeanId(Integer orderBeanId);
}
