package com.yitsd.book.dao;

import com.yitsd.book.pojo.User;

public interface UserDAO {

    User getUser(String uname, String pwd);


    void addUser(User user);


    User getUser(String uname);
}
