package com.yitsd.qqzone.pojo;

import java.util.Date;

/**
 * @ClassName Reply
 * @Date 2022/7/2 19:47
 */
public class Reply {

    private Integer id;
    private String content;
    private Date topicDate;
    private UserBasic author;
    private Topic topic;//M:1

    private HostReply hostReply;//1:1


    public Reply(){}


    public HostReply getHostReply() {
        return hostReply;
    }

    public void setHostReply(HostReply hostReply) {
        this.hostReply = hostReply;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTopicDate() {
        return topicDate;
    }

    public void setTopicDate(Date topicDate) {
        this.topicDate = topicDate;
    }

    public UserBasic getAuthor() {
        return author;
    }

    public void setAuthor(UserBasic author) {
        this.author = author;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }
}
