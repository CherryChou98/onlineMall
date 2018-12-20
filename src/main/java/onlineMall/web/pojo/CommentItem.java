package onlineMall.web.pojo;

import java.util.Date;

public class CommentItem {
    private Integer commentId;

    private Integer itemId;

    private Integer userId;

    private String content;

    private Date time;

    private Integer bakcBack;

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
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

    public Integer getBakcBack() {
        return bakcBack;
    }

    public void setBakcBack(Integer bakcBack) {
        this.bakcBack = bakcBack;
    }
}