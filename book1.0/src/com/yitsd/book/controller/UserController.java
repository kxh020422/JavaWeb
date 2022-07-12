package com.yitsd.book.controller;

import com.yitsd.book.pojo.Cart;
import com.yitsd.book.pojo.User;
import com.yitsd.book.service.BookService;
import com.yitsd.book.service.CartItemService;
import com.yitsd.book.service.UserService;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @ClassName UserController
 * @Date 2022/7/6 15:39
 */
public class UserController {

    private UserService userService;
    private CartItemService cartItemService;

    public String login(String uname, String pwd, HttpSession session) {
        User user = userService.login(uname, pwd);

        if (user != null) {
            Cart cart = cartItemService.getCart(user);
            user.setCart(cart);

            session.setAttribute("currUser", user);
            return "redirect:book.do?";
        }
        return "user/login";
    }


    public String regist(String verifyCode, String uname, String pwd, String email, HttpSession session, HttpServletResponse response) throws Exception {
        Object kaptchaCodeObj = session.getAttribute("KAPTCHA_SESSION_KEY");
        if (kaptchaCodeObj == null || !verifyCode.equals(kaptchaCodeObj)) {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            //out.println("<script language='javascript'>alert('验证码不正确！');window.location.href='page.do?operate=page&page=user/regist';</script>");
            out.println("<script language='javascript'>alert('验证码不正确！');</script>");
            //return "user/regist";
            return "user/regist";
        } else {
            if (verifyCode.equals(kaptchaCodeObj)) {
                userService.regist(new User(uname, pwd, email, 0));
                return "user/login";
            }
        }
        return "user/login";
    }

    public String ckUname(String uname) {
        User user = userService.getUser(uname);
        if (user != null) {
            //该用户名已经被注册

            return "json:{'uname':'1'}";
//            return "ajax:1";
        } else {

            return "json:{'uname':'0'}";
//            return "ajax:0";
        }

    }
}
