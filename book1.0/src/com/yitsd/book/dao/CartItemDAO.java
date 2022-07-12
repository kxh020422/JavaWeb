package com.yitsd.book.dao;

import com.yitsd.book.pojo.CartItem;
import com.yitsd.book.pojo.User;

import java.util.List;

public interface CartItemDAO {

    //新增购物车项
    void addCartItem(CartItem cartItem);

    //修改特定的购物车项
    void updateCartItem(CartItem cartItem);

    //获取特定用户的所有购物车项
    List<CartItem> getCartItemList(User user);

    //删除指定的购物车项
    void delCartItem(CartItem cartItem);

}
