package onlineMall.web.pojo;

import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @ Package: onlineMall.web.pojo
 * @ Author     ：linsola
 * @ Date       ：Created in 16:49 2018/12/24
 * @ Description：
 * @ Modified By：
 * @ Version:
 */
@Component
public class InsertOrder {
    private Integer[] orderIds;

    private Date[] times;

    private Integer[] numbers;

    private Double[] prices;

    private String[] receivers;

    private String[] phones;

    private String[] addresses;

    private String[] statuses;

    private Integer[] userIds;

    private Integer[] itemIds;

    public Integer[] getOrderIds() {
        return orderIds;
    }

    public void setOrderIds(Integer[] orderIds) {
        this.orderIds = orderIds;
    }

    public Date[] getTimes() {
        return times;
    }

    public void setTimes(Date[] times) {
        this.times = times;
    }

    public Integer[] getNumbers() {
        return numbers;
    }

    public void setNumbers(Integer[] numbers) {
        this.numbers = numbers;
    }

    public Double[] getPrices() {
        return prices;
    }

    public void setPrices(Double[] prices) {
        this.prices = prices;
    }

    public String[] getReceivers() {
        return receivers;
    }

    public void setReceivers(String[] receivers) {
        this.receivers = receivers;
    }

    public String[] getPhones() {
        return phones;
    }

    public void setPhones(String[] phones) {
        this.phones = phones;
    }

    public String[] getAddresses() {
        return addresses;
    }

    public void setAddresses(String[] addresses) {
        this.addresses = addresses;
    }

    public String[] getStatuses() {
        return statuses;
    }

    public void setStatuses(String[] statuses) {
        this.statuses = statuses;
    }

    public Integer[] getUserIds() {
        return userIds;
    }

    public void setUserIds(Integer[] userIds) {
        this.userIds = userIds;
    }

    public Integer[] getItemIds() {
        return itemIds;
    }

    public void setItemIds(Integer[] itemIds) {
        this.itemIds = itemIds;
    }
}
