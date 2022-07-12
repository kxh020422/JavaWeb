package com.yitsd.book.service.impl;

import com.yitsd.book.dao.CartItemDAO;
import com.yitsd.book.pojo.Book;
import com.yitsd.book.pojo.Cart;
import com.yitsd.book.pojo.CartItem;
import com.yitsd.book.pojo.User;
import com.yitsd.book.service.BookService;
import com.yitsd.book.service.CartItemService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName CartItemServiceImpl
 * @Date 2022/7/6 22:34
 */
public class CartItemServiceImpl implements CartItemService {


    private CartItemDAO cartItemDAO;
    private BookService bookService;

    @Override
    public void addCartItem(CartItem cartItem) {
        cartItemDAO.addCartItem(cartItem);
    }

    @Override
    public void updateCartItem(CartItem cartItem) {
        cartItemDAO.updateCartItem(cartItem);
    }

    @Override
    public void addOrUpdateCartItem(CartItem cartItem, Cart cart) {
        //判断购物车中是否有这本书的cartItem 有->update 无->add
        //1.如果当前用户的购物车中已经存在这个图书了，那么将购物车中这本图书的数量+1
        //2.否则，在我的购物车中新增一个这本图书的cartItem
        if (cart != null) {
            Map<Integer, CartItem> cartItemMap = cart.getCartItemMap();
            if (cartItemMap == null) {
                cartItemMap = new HashMap<>();
            }
            if (cartItemMap.containsKey(cartItem.getBook().getId())) {
                CartItem cartItemTemp = cartItemMap.get(cartItem.getBook().getId());
                cartItemTemp.setBuyCount(cartItemTemp.getBuyCount() + 1);
                updateCartItem(cartItemTemp);
            } else {
                addCartItem(cartItem);
            }
        } else {
            addCartItem(cartItem);
        }
    }

    @Override
    public List<CartItem> getCartItemList(User user) {

        List<CartItem> cartItemList = cartItemDAO.getCartItemList(user);

        for (CartItem cartItem : cartItemList) {
            Book book = bookService.getBook(cartItem.getBook().getId());
            cartItem.setBook(book);
            cartItem.getXj();
        }

        return cartItemList;
    }

    @Override
    public Cart getCart(User user) {
        List<CartItem> cartItemList = getCartItemList(user);
        Map<Integer, CartItem> cartItemMap = new HashMap<>();
        Cart cart = new Cart();
        for (CartItem cartItem : cartItemList) {
            cartItemMap.put(cartItem.getBook().getId(), cartItem);
        }
        cart.setCartItemMap(cartItemMap);
        cart.getTotalCount();
        cart.getTotalBookCount();
        cart.getTotalMoney();
        return cart;
    }
}
