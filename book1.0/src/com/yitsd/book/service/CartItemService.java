package com.yitsd.book.service;

import com.yitsd.book.dao.CartItemDAO;
import com.yitsd.book.pojo.Cart;
import com.yitsd.book.pojo.CartItem;
import com.yitsd.book.pojo.User;

import java.util.List;

public interface CartItemService {


    void addCartItem(CartItem cartItem);

    void updateCartItem(CartItem cartItem);

    void addOrUpdateCartItem(CartItem cartItem, Cart cart);


    List<CartItem> getCartItemList(User user);

    //加载指定的用户车信息
    Cart getCart(User user);

}
