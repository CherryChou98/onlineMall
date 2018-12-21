package onlineMall.web.dao;

import onlineMall.web.pojo.Order;
import onlineMall.web.pojo.ViewOrder;

import java.util.ArrayList;

public interface OrderDao {
    /**
     * 商家查看订单信息，item表与shopping_cart表与order表与user表连接
     */
    public ArrayList<ViewOrder> viewOrder(int shopId);
    /**
     * 商家对订单进行发货，STATUS字段由1（已付款未发货）变2（已发货未收货）
     */
    public boolean deliverItem(int orderId);

   /* int deleteByPrimaryKey(Integer orderId);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Integer orderId);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);*/
}