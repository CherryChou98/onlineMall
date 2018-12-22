package onlineMall.web.pojo;

import org.springframework.stereotype.Component;

@Component
public class ShoppingCart {
    private Integer shoppingCartId;

    private Integer itemId;

    private Integer orderId;

    private Integer userId;

    private Integer number;

    private String state;

    public Integer getShoppingCartId() {
        return shoppingCartId;
    }

    public void setShoppingCartId(Integer shoppingCartId) {
        this.shoppingCartId = shoppingCartId;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getState() { return state; }

    public void setState(String state) { this.state = state; }
}