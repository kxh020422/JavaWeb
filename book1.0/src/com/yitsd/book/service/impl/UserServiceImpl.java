package com.yitsd.book.service.impl;

import com.yitsd.book.dao.UserDAO;
import com.yitsd.book.pojo.User;
import com.yitsd.book.service.UserService;

/**
 * @ClassName UserServiceImpl
 * @Date 2022/7/6 15:44
 */
public class UserServiceImpl implements UserService {
    private UserDAO userDAO;

    @Override
    public User login(String uname, String pwd) {
        return userDAO.getUser(uname, pwd);
    }

    @Override
    public void regist(User user) {
        userDAO.addUser(user);
    }

    @Override
    public User getUser(String uname) {
        return userDAO.getUser(uname);
    }
}
