package com.yitsd.qqzone.service.impl;

import com.yitsd.qqzone.dao.TopicDAO;
import com.yitsd.qqzone.pojo.Topic;
import com.yitsd.qqzone.pojo.UserBasic;
import com.yitsd.qqzone.service.TopicService;

import java.util.List;

/**
 * @ClassName TopicServiceImpl
 * @Date 2022/7/2 21:51
 */
public class TopicServiceImpl implements TopicService {

    private TopicDAO topicDAO = null;

    @Override
    public List<Topic> getTopicList(UserBasic userBasic) {
        return topicDAO.getTopicList(userBasic);
    }
}
