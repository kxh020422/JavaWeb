package com.yitsd.book.controller;

import com.google.gson.Gson;
import com.yitsd.book.pojo.Book;
import com.yitsd.book.pojo.Cart;
import com.yitsd.book.pojo.CartItem;
import com.yitsd.book.pojo.User;
import com.yitsd.book.service.CartItemService;

import javax.servlet.ServletRegistration;
import javax.servlet.http.HttpSession;

/**
 * @ClassName CartController
 * @Date 2022/7/6 21:41
 */
public class CartController {

    private CartItemService cartItemService;

    //加载当前用户的购物车信息
    public String index(HttpSession session) {
        User user = (User) session.getAttribute("currUser");
        Cart cart = cartItemService.getCart(user);
        user.setCart(cart);
        session.setAttribute("currUser", user);
        return "cart/cart";
    }


    public String addCart(Integer bookId, HttpSession session) {
        //将指定的图书添加到当前用户的购物车中
        User user = (User) session.getAttribute("currUser");
        CartItem cartItem = new CartItem(new Book(bookId), 1, user);

        cartItemService.addOrUpdateCartItem(cartItem, user.getCart());

        return "redirect:book.do";
    }

    public String editCart(Integer cartItemId, Integer buyCount) {
        cartItemService.updateCartItem(new CartItem(cartItemId, buyCount));

        return "";
    }

    public String cartInfo(HttpSession session) {
        User user = (User) session.getAttribute("currUser");
        Cart cart = cartItemService.getCart(user);
        Gson gson = new Gson();
        String cartJsonStr = gson.toJson(cart);


        return "json:" + cartJsonStr;

    }

}
