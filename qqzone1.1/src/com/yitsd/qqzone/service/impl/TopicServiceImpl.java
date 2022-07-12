package com.yitsd.qqzone.service.impl;

import com.yitsd.qqzone.dao.TopicDAO;
import com.yitsd.qqzone.pojo.Reply;
import com.yitsd.qqzone.pojo.Topic;
import com.yitsd.qqzone.pojo.UserBasic;
import com.yitsd.qqzone.service.ReplyService;
import com.yitsd.qqzone.service.TopicService;
import com.yitsd.qqzone.service.UserBasicService;

import java.util.List;

/**
 * @ClassName TopicServiceImpl
 * @Date 2022/7/2 21:51
 */
public class TopicServiceImpl implements TopicService {

    private TopicDAO topicDAO = null;
    //此处引用的是replyService，而不是replyDAO
    private ReplyService replyService;
    private UserBasicService userBasicService;

    @Override
    public List<Topic> getTopicList(UserBasic userBasic) {
        return topicDAO.getTopicList(userBasic);
    }

    @Override
    public Topic getTopic(Integer id) {
        Topic topic = topicDAO.getTopic(id);
        UserBasic author = topic.getAuthor();
        author = userBasicService.getUserBasicById(author.getId());
        topic.setAuthor(author);
        return topic;
    }

    @Override
    public void delTopic(Integer id) {
        Topic topic = topicDAO.getTopic(id);
        if (topic != null) {
            replyService.delReplyList(topic);
            topicDAO.delTopic(topic);
        }
    }

    @Override
    public void addTopic(Topic topic) {
        topicDAO.addTopic(topic);
    }

    @Override
    public Topic getTopicById(Integer id) {
        Topic topic = getTopic(id);
        List<Reply> replyList = replyService.getReplyListByTopicId(topic.getId());
        topic.setReplyList(replyList);

        return topic;
    }
}



