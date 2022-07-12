package com.yitsd.book.controller;

import com.yitsd.book.pojo.Book;
import com.yitsd.book.pojo.Cart;
import com.yitsd.book.pojo.User;
import com.yitsd.book.service.BookService;
import com.yitsd.book.service.CartItemService;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @ClassName BookController
 * @Date 2022/7/6 20:42
 */
public class BookController {


    public BookService bookService;

    private CartItemService cartItemService;

    public String index(HttpSession session){

        List<Book> bookList = bookService.getBookList();
        User user = (User) session.getAttribute("currUser");
        Cart cart = cartItemService.getCart(user);
        user.setCart(cart);
//        session.setAttribute("currUser",user);
        session.setAttribute("bookList",bookList);
        return "index";
    }

}
