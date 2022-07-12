package com.yitsd.qqzone.service.impl;

import com.yitsd.qqzone.dao.HostReplyDAO;
import com.yitsd.qqzone.pojo.HostReply;
import com.yitsd.qqzone.service.HostReplyService;

/**
 * @ClassName HostReplyServiceImpl
 * @Date 2022/7/4 17:47
 */
public class HostReplyServiceImpl implements HostReplyService {

    private HostReplyDAO hostReplyDAO;

    @Override
    public HostReply getHostReplyByReplyId(Integer replyId) {
        return hostReplyDAO.getHostReplyByReplyId(replyId);
    }

    @Override
    public void delHostReply(Integer id) {
        hostReplyDAO.delHostReply(id);
    }
}
