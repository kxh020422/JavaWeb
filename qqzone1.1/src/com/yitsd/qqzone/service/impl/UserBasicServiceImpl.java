package com.yitsd.qqzone.service.impl;

import com.yitsd.qqzone.dao.UserBasicDAO;
import com.yitsd.qqzone.pojo.UserBasic;
import com.yitsd.qqzone.service.UserBasicService;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName UserBasicServiceImpl
 * @Date 2022/7/2 21:39
 */
public class UserBasicServiceImpl implements UserBasicService {

    private UserBasicDAO userBasicDAO = null;

    @Override
    public UserBasic login(String loginId, String pwd) {
        return userBasicDAO.getUserBasic(loginId, pwd);
    }

    @Override
    public List<UserBasic> getFriendList(UserBasic userBasic) {

        List<UserBasic> userBasicList = userBasicDAO.getUserBasicList(userBasic);
        List<UserBasic> friendList = new ArrayList<>();

        for (UserBasic friend : userBasicList) {
            friendList.add(userBasicDAO.getUserBasicById(friend.getId()));
        }

        return friendList;
    }

    @Override
    public UserBasic getUserBasicById(Integer id) {
        return userBasicDAO.getUserBasicById(id);
    }

}
