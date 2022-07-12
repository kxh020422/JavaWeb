package com.yitsd.qqzone.dao;

import com.yitsd.qqzone.pojo.Topic;
import com.yitsd.qqzone.pojo.UserBasic;

import java.util.List;

public interface TopicDAO {
    //获取指定用户的所有日志
    public List<Topic> getTopicList(UserBasic userBasic);

    //添加日志功能
    public void addTopic(Topic topic);

    //删除日志
    public void delTopic(Topic topic);

    //获取特定日志信息
    public Topic getTopic(Integer id);
}
