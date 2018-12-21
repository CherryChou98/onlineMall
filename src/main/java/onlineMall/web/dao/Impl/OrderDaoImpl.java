package onlineMall.web.dao.Impl;

import onlineMall.web.dao.Dbutil;
import onlineMall.web.dao.OrderDao;
import onlineMall.web.pojo.ViewOrder;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * @ Package: onlineMall.web.dao.Impl
 * @ Author     ：linsola
 * @ Date       ：Created in 18:24 2018/12/21
 * @ Description：
 * @ Modified By：
 * @ Version:
 */
@Repository
public class OrderDaoImpl implements OrderDao {
    private Dbutil dbutil;

    public OrderDaoImpl(Dbutil dbutil) {
        this.dbutil = Dbutil.getInstance();
        try {
            dbutil.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<ViewOrder> viewOrder(int shopId) {
        ArrayList<ViewOrder> list = new ArrayList<>();
        String sql = "SELECT item.`ITEM_ID`,shopping_cart.`ORDER_ID`,item.`NAME` AS ITEM_NAME,item.`PRICE` AS SINGLE_PRICE,NUMBER,\n" +
                "ORDER_TIME,orders.`PRICE` AS TOTAL_PRICE,RECEIVER,orders.PHONE,ADDRESS,orders.`STATUS`,orders.`USER_ID`,USER_NAME FROM item LEFT JOIN shopping_cart ON item.`ITEM_ID`=shopping_cart.`ITEM_ID` \n" +
                "LEFT JOIN orders ON shopping_cart.ORDER_ID=orders.`ORDER_ID`\n" +
                "LEFT JOIN USER ON orders.`USER_ID`=user.`USER_ID`\n" +
                "WHERE item.`SHOP_ID`=? AND item.`STATE`=2";
        try {
            ResultSet rs = dbutil.executeQuery(sql,shopId);
            while (rs.next()){
                ViewOrder viewOrder = new ViewOrder();
                viewOrder.setItemId(rs.getInt("ITEM_ID"));
                viewOrder.setOrderId(rs.getInt("ORDER_ID"));
                viewOrder.setItemName(rs.getString("ITEM_NAME"));
                viewOrder.setSinglePrice(rs.getDouble("SINGLE_PRICE"));
                viewOrder.setNumber(rs.getInt("NUMBER"));
                viewOrder.setOrderTime(rs.getDate("ORDER_TIME"));
                viewOrder.setTotalPrice(rs.getDouble("TOTAL_PRICE"));
                viewOrder.setReceiver(rs.getString("RECEIVER"));
                viewOrder.setPhone(rs.getString("PHONE"));
                viewOrder.setAddress(rs.getString("ADDRESS"));
                viewOrder.setStatus(rs.getString("STATUS"));
                viewOrder.setUserId(rs.getInt("USER_ID"));
                viewOrder.setUserName(rs.getString("USER_NAME"));
                list.add(viewOrder);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean deliverItem(int orderId) {
        boolean flag = false;
        String sql = "UPDATE orders SET STATUS='2' WHERE ORDER_ID=?";
        try {
            int r = dbutil.executeUpdate(sql,orderId);
            if(r!=0){
                flag = true;
            }else {
                flag = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }
}
