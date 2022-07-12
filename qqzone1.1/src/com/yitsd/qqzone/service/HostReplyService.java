package com.yitsd.qqzone.service;

import com.yitsd.qqzone.pojo.HostReply;

public interface HostReplyService {
    HostReply getHostReplyByReplyId(Integer replyId);

    void delHostReply(Integer id);
}
