package com.yitsd.qqzone.controller;

import com.yitsd.qqzone.pojo.Reply;
import com.yitsd.qqzone.pojo.Topic;
import com.yitsd.qqzone.pojo.UserBasic;
import com.yitsd.qqzone.service.ReplyService;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @ClassName ReplyController
 * @Date 2022/7/5 1:23
 */
public class ReplyController {

    private ReplyService replyService;

    public String addReply(String content, Integer topicId, HttpSession session) {
        UserBasic author = (UserBasic) session.getAttribute("userBasic");
        Reply reply = new Reply(content, new Date(), author, new Topic(topicId));
        replyService.addReply(reply);
        return "redirect:topic.do?operate=topicDetail&id=" + topicId;
    }

    public String delReply(Integer replyId, Integer topicId) {
        replyService.delReply(replyId);
        return "redirect:topic.do?operate=topicDetail&id=" + topicId;

    }


}
