package com.yitsd.qqzone.service;

import com.yitsd.qqzone.pojo.Reply;
import com.yitsd.qqzone.pojo.Topic;

import java.util.List;

public interface ReplyService {

    //根据Topic的id获取关联的所有的回复
    List<Reply> getReplyListByTopicId(Integer id);

    //添加回复
    void addReply(Reply reply);

    //删除指定回复
    void delReply(Integer id);

    //删除指定的日志关联的所有的回复
    void delReplyList(Topic topic);

}
