package com.yitsd.qqzone.controller;

import com.yitsd.qqzone.pojo.Topic;
import com.yitsd.qqzone.pojo.UserBasic;
import com.yitsd.qqzone.service.TopicService;
import com.yitsd.qqzone.service.UserBasicService;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @ClassName UserController
 * @Date 2022/7/3 16:24
 */
public class UserController {
    private UserBasicService userBasicService;
    private TopicService topicService;

    public String login(String loginId, String pwd, HttpSession session) {

        //登陆验证
        UserBasic userBasic = userBasicService.login(loginId, pwd);
        if (userBasic != null) {
            List<UserBasic> friendList = userBasicService.getFriendList(userBasic);
            List<Topic> topicList = topicService.getTopicList(userBasic);

            userBasic.setFriendList(friendList);
            userBasic.setTopicList(topicList);

            session.setAttribute("userBasic", userBasic);
            return "index";
        } else {
            return "login";
        }

    }

}
