package com.yitsd.book.dao.impl;

import com.yitsd.book.dao.CartItemDAO;
import com.yitsd.book.pojo.CartItem;
import com.yitsd.book.pojo.User;
import com.yitsd.myssm.basedao.BaseDAO;

import java.util.List;

/**
 * @ClassName CartItemDAOImpl
 * @Date 2022/7/6 21:54
 */
public class CartItemDAOImpl extends BaseDAO<CartItem> implements CartItemDAO {
    @Override
    public void addCartItem(CartItem cartItem) {
        executeUpdate("insert into t_cart_item values(0,?,?,?)", cartItem.getBook().getId(), cartItem.getBuyCount(), cartItem.getUserBean().getId());
    }

    @Override
    public void updateCartItem(CartItem cartItem) {
        int i = executeUpdate("update t_cart_item set buyCount = ? where id = ?", cartItem.getBuyCount(), cartItem.getId());
        System.out.println("i = " + i);
    }

    @Override
    public List<CartItem> getCartItemList(User user) {
        return executeQuery("select * from t_cart_item where userBean = ?",user.getId());
    }

    @Override
    public void delCartItem(CartItem cartItem) {
        executeUpdate("delete from t_cart_item where id = ?",cartItem.getId());
    }
}
