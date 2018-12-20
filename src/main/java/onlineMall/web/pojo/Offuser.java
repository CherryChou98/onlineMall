package onlineMall.web.pojo;

import java.util.Date;

public class Offuser extends OffuserKey {
    private Integer adminId;

    private Date offuserDate;

    private Integer offuserTime;

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public Date getOffuserDate() {
        return offuserDate;
    }

    public void setOffuserDate(Date offuserDate) {
        this.offuserDate = offuserDate;
    }

    public Integer getOffuserTime() {
        return offuserTime;
    }

    public void setOffuserTime(Integer offuserTime) {
        this.offuserTime = offuserTime;
    }
}