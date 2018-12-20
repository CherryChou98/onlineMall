package onlineMall.web.pojo;

import java.util.Date;

public class Offitem extends OffitemKey {
    private Integer adminId;

    private Date offitemDate;

    private Integer offitemTime;

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public Date getOffitemDate() {
        return offitemDate;
    }

    public void setOffitemDate(Date offitemDate) {
        this.offitemDate = offitemDate;
    }

    public Integer getOffitemTime() {
        return offitemTime;
    }

    public void setOffitemTime(Integer offitemTime) {
        this.offitemTime = offitemTime;
    }
}