package onlineMall.web.pojo;

import org.springframework.stereotype.Component;

@Component
public class OffuserKey {
    private Integer offuserId;

    private Integer userId;

    public Integer getOffuserId() {
        return offuserId;
    }

    public void setOffuserId(Integer offuserId) {
        this.offuserId = offuserId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}