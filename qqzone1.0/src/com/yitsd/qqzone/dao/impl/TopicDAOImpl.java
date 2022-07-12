package com.yitsd.qqzone.dao.impl;

import com.yitsd.myssm.basedao.BaseDAO;
import com.yitsd.qqzone.dao.TopicDAO;
import com.yitsd.qqzone.pojo.Topic;
import com.yitsd.qqzone.pojo.UserBasic;

import java.util.List;

/**
 * @ClassName TopicDAOImpl
 * @Date 2022/7/2 21:14
 */
public class TopicDAOImpl extends BaseDAO<Topic> implements TopicDAO {
    @Override
    public List<Topic> getTopicList(UserBasic userBasic) {
        return super.executeQuery("select * from t_topic where author = ?",userBasic.getId());
    }

    @Override
    public void addTopic(Topic topic) {

    }

    @Override
    public void delTopic(Topic topic) {

    }

    @Override
    public Topic getTopic(Integer id) {
        return null;
    }
}
