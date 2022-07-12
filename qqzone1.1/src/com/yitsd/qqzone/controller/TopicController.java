package com.yitsd.qqzone.controller;

import com.yitsd.qqzone.pojo.Topic;
import com.yitsd.qqzone.pojo.UserBasic;
import com.yitsd.qqzone.service.TopicService;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * @ClassName TopicController
 * @Date 2022/7/4 17:14
 */
public class TopicController {


    private TopicService topicService;


    public String topicDetail(Integer id, HttpSession session) {
        Topic topic = topicService.getTopicById(id);
        session.setAttribute("topic", topic);
        return "frames/detail";

    }


    public String addTopic(String title, String content, HttpSession session) {
        UserBasic userBasic = (UserBasic) session.getAttribute("userBasic");
        topicService.addTopic(new Topic(title, content, new Date(), userBasic));
        return "redirect:topic.do?operate=getTopicList";
    }


    public String delTopic(Integer topicId) {
        topicService.delTopic(topicId);
        return "redirect:topic.do?operate=getTopicList";
    }

    public String getTopicList(HttpSession session) {
        UserBasic userBasic = (UserBasic) session.getAttribute("userBasic");
        List<Topic> topicList = topicService.getTopicList(userBasic);
        userBasic.setTopicList(topicList);
        session.setAttribute("friend", userBasic);
        return "frames/main";
    }

}
