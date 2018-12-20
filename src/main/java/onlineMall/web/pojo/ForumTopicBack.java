package onlineMall.web.pojo;

import java.util.Date;

public class ForumTopicBack {
    private Integer forumTopicBackId;

    private Integer forumTopicId;

    private Integer userId;

    private String content;

    private Date time;

    private Integer backBack;

    public Integer getForumTopicBackId() {
        return forumTopicBackId;
    }

    public void setForumTopicBackId(Integer forumTopicBackId) {
        this.forumTopicBackId = forumTopicBackId;
    }

    public Integer getForumTopicId() {
        return forumTopicId;
    }

    public void setForumTopicId(Integer forumTopicId) {
        this.forumTopicId = forumTopicId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getBackBack() {
        return backBack;
    }

    public void setBackBack(Integer backBack) {
        this.backBack = backBack;
    }
}