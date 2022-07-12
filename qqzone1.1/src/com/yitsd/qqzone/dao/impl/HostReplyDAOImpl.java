package com.yitsd.qqzone.dao.impl;

import com.yitsd.myssm.basedao.BaseDAO;
import com.yitsd.qqzone.dao.HostReplyDAO;
import com.yitsd.qqzone.pojo.HostReply;

/**
 * @ClassName HostReplyDAOImpl
 * @Date 2022/7/4 17:50
 */
public class HostReplyDAOImpl extends BaseDAO<HostReply> implements HostReplyDAO {
    @Override
    public HostReply getHostReplyByReplyId(Integer replyId) {
        return load("select * from t_host_reply where reply = ?", replyId);
    }

    @Override
    public void delHostReply(Integer id) {
        super.executeUpdate("delete from t_host_reply where id = ?", id);
    }
}
