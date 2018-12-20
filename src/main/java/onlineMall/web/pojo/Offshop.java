package onlineMall.web.pojo;

import java.util.Date;

public class Offshop extends OffshopKey {
    private Integer adminId;

    private Date offshopDate;

    private Integer offshopTime;

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public Date getOffshopDate() {
        return offshopDate;
    }

    public void setOffshopDate(Date offshopDate) {
        this.offshopDate = offshopDate;
    }

    public Integer getOffshopTime() {
        return offshopTime;
    }

    public void setOffshopTime(Integer offshopTime) {
        this.offshopTime = offshopTime;
    }
}