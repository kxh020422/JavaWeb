package com.yitsd.book.dao;

import com.yitsd.book.pojo.OrderBean;
import com.yitsd.book.pojo.User;

import java.util.List;

public interface OrderDAO {
    //添加订单
    void addOrderBean(OrderBean orderBean);

    //获取指定用户的订单列表
    List<OrderBean> getOrderList(User user);

    //
    Integer getOrderTotalBookCount(OrderBean orderBean);
}
