package onlineMall.web.pojo;

import java.util.Date;

public class ForumTopic {
    private Integer forumTopicId;

    private Integer userId;

    private String title;

    private Date time;

    private String content;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}