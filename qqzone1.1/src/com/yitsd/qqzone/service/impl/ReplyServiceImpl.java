package com.yitsd.qqzone.service.impl;

import com.yitsd.qqzone.dao.ReplyDAO;
import com.yitsd.qqzone.pojo.HostReply;
import com.yitsd.qqzone.pojo.Reply;
import com.yitsd.qqzone.pojo.Topic;
import com.yitsd.qqzone.pojo.UserBasic;
import com.yitsd.qqzone.service.HostReplyService;
import com.yitsd.qqzone.service.ReplyService;
import com.yitsd.qqzone.service.UserBasicService;

import java.util.List;

/**
 * @ClassName ReplyServiceImpl
 * @Date 2022/7/4 17:25
 */
public class ReplyServiceImpl implements ReplyService {


    private ReplyDAO replyDAO;
    private HostReplyService hostReplyService;

    private UserBasicService userBasicService;


    @Override
    public List<Reply> getReplyListByTopicId(Integer id) {
        List<Reply> replyList = replyDAO.getReplyList(new Topic(id));
        for (Reply reply : replyList) {
            HostReply hostReply = hostReplyService.getHostReplyByReplyId(reply.getId());
            UserBasic userBasic = userBasicService.getUserBasicById(reply.getAuthor().getId());
            reply.setAuthor(userBasic);
            reply.setHostReply(hostReply);
        }
        return replyList;
    }

    @Override
    public void addReply(Reply reply) {
        replyDAO.addReply(reply);
    }

    @Override
    public void delReply(Integer id) {
        //1.根据ID获取reply
        Reply reply = replyDAO.getReply(id);
        if (reply != null) {
            //2.如果reply有关联的hostReply 则先删除hostReply
            HostReply hostReply = hostReplyService.getHostReplyByReplyId(reply.getId());
            if (hostReply != null) {
                hostReplyService.delHostReply(hostReply.getId());
            }
            replyDAO.delReply(id);
        }
    }

    @Override
    public void delReplyList(Topic topic) {
        List<Reply> replyList = replyDAO.getReplyList(topic);
        if (replyList != null) {
            for (Reply reply : replyList) {
                delReply(reply.getId());
            }
        }
    }



}
