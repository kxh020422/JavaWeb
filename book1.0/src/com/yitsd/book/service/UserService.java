package com.yitsd.book.service;

import com.yitsd.book.pojo.User;

public interface UserService {
    User login(String uname, String pwd);

    void regist(User user);

    User getUser(String uname);
}
