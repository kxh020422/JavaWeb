package com.yitsd.book.dao.impl;

import com.yitsd.book.dao.OrderItemDAO;
import com.yitsd.book.pojo.OrderItem;
import com.yitsd.myssm.basedao.BaseDAO;

import java.util.List;

/**
 * @ClassName OrderItemDAOImpl
 * @Date 2022/7/7 17:44
 */
public class OrderItemDAOImpl extends BaseDAO<OrderItem> implements OrderItemDAO {
    @Override
    public void addOrderItem(OrderItem orderItem) {
        executeUpdate("insert into t_order_item values(0,?,?,?)",orderItem.getBook().getId(),orderItem.getBuyCount(),orderItem.getOrderBean().getId());
    }

    @Override
    public List<OrderItem> getOrderItemByOrderBeanId(Integer orderBeanId) {
        return executeQuery("select * from t_order_item where orderBean = ?",orderBeanId);
    }
}
