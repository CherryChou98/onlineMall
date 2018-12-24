package onlineMall.web.dao;

import onlineMall.web.pojo.InsertOrder;
import onlineMall.web.pojo.Order;
import onlineMall.web.pojo.ViewOrder;

import java.util.ArrayList;

public interface OrderDao {
    /**
     * 商家查看订单信息，item表与orders表与user表连接
     */
    public ArrayList<ViewOrder> shopViewOrder(int shopId);

    /**
     * 商家对订单进行发货，STATUS字段由1（已付款未发货）变2（已发货未收货）
     */
    public boolean deliverItem(int orderId);

    /**
     * 商家搜索订单，传入订单id
     * */
    public ViewOrder shopQueryOrder(int orderId);

    /**
     * 用户对购物车进行下单
     * */
    public boolean addOrder(InsertOrder insertOrder);

    /**
     * 用户查看订单信息，传入userId，item表与order表连接
     * */
    public ArrayList<Order> customerViewOrder(int userId);


   /* int deleteByPrimaryKey(Integer orderId);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Integer orderId);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);*/
}