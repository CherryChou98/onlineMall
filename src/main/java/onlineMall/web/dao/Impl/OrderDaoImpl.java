package onlineMall.web.dao.Impl;

import onlineMall.web.dao.Dbutil;
import onlineMall.web.dao.OrderDao;
import onlineMall.web.pojo.InsertOrder;
import onlineMall.web.pojo.Order;
import onlineMall.web.pojo.ViewOrder;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

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
    public ArrayList<ViewOrder> shopViewOrder(int shopId) {
        ArrayList<ViewOrder> list = new ArrayList<>();
        String sql = "SELECT item.`ITEM_ID`,orders.`ORDER_ID`,item.`NAME` AS ITEM_NAME,item.`PRICE` AS SINGLE_PRICE,NUMBER,\n" +
                "ORDER_TIME,orders.`PRICE` AS TOTAL_PRICE,RECEIVER,orders.PHONE,ADDRESS,STATUS,orders.`USER_ID`,USER_NAME FROM item \n" +
                "INNER JOIN orders ON item.`ITEM_ID`=orders.`ITEM_ID`\n" +
                "INNER JOIN USER ON orders.`USER_ID`=user.`USER_ID`\n" +
                "WHERE item.`SHOP_ID`=? AND item.`STATE`=2";
        try {
            ResultSet rs = dbutil.executeQuery(sql,shopId);
            while (rs.next()){
                ViewOrder viewOrder = new ViewOrder();
                String status = null;
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
                String status1 = rs.getString("STATUS");
                if("0".equals(status1)){
                    status = "未付款";
                }else if("1".equals(status1)){
                    status = "已付款未发货";
                }else if("2".equals(status1)){
                    status = "已发货未收货";
                }else if("3".equals(status1)){
                    status = "已收货未评价";
                }else if("4".equals(status1)){
                    status = "已收货已评价";
                }
                viewOrder.setStatus(status);
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

    @Override
    public ViewOrder shopQueryOrder(int orderId) {
        ViewOrder viewOrder = new ViewOrder();
        String status = null;
        String sql = "SELECT orders.`ITEM_ID`,ORDER_ID,item.`NAME` AS ITEM_NAME,item.`PRICE` AS SINGLE_PRICE,NUMBER,\n" +
                "ORDER_TIME,orders.`PRICE` AS TOTAL_PRICE,RECEIVER,orders.PHONE,ADDRESS,STATUS,orders.`USER_ID`,USER_NAME FROM orders \n" +
                "INNER JOIN item ON orders.`ITEM_ID`=item.`ITEM_ID`\n" +
                "INNER JOIN USER ON orders.`USER_ID`=user.`USER_ID`\n" +
                "WHERE orders.`ORDER_ID`=?";
        try {
            ResultSet rs = dbutil.executeQuery(sql,orderId);
            while (rs.next()){
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
                String status1 = rs.getString("STATUS");
                if("0".equals(status1)){
                    status = "未付款";
                }else if("1".equals(status1)){
                    status = "已付款未发货";
                }else if("2".equals(status1)){
                    status = "已发货未收货";
                }else if("3".equals(status1)){
                    status = "已收货未评价";
                }else if("4".equals(status1)){
                    status = "已收货已评价";
                }
                viewOrder.setStatus(status);
                viewOrder.setUserId(rs.getInt("USER_ID"));
                viewOrder.setUserName(rs.getString("USER_NAME"));
            }
            return viewOrder;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean addOrder(InsertOrder insertOrder) {
        boolean flag = false;
        String sql = "INSERT INTO orders(ORDER_ID,ORDER_TIME,NUMBER,PRICE,RECEIVER,PHONE,ADDRESS,STATUS,USER_ID,ITEM_ID) VALUES(?,?,?,?,?,?,?,?,?,?)";
        for(int i=0;i<insertOrder.getOrderIds().length;i++){
            Date orderTime = new Date();
            int number = insertOrder.getNumbers()[i];
            double price = insertOrder.getPrices()[i];
            String receiver = insertOrder.getReceivers()[i];
            String phone = insertOrder.getPhones()[i];
            String address = insertOrder.getAddresses()[i];
            String status = "0";
            int userId = insertOrder.getUserIds()[i];
            int itemId = insertOrder.getItemIds()[i];
            try {
                int orderId = dbutil.countOrder()+1;
                int r = dbutil.executeUpdate(sql,orderId,orderTime,number,price,receiver,phone,address,status,userId,itemId);
                if(r!=0){
                    flag = true;
                }else {
                    flag = false;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return flag;
    }

    @Override
    public ArrayList<Order> customerViewOrder(int userId) {
        ArrayList<Order> list = new ArrayList<>();
        String sql = "SELECT ORDER_ID,ORDER_TIME,NUMBER,PRICE,RECEIVER,PHONE,ADDRESS,STATUS,USER_ID,ITEM_ID FROM orders WHERE USER_ID=?";
        try {
            ResultSet rs = dbutil.executeQuery(sql,userId);
            while (rs.next()){
                Order order = new Order();
                order.setOrderId(rs.getInt("ORDER_ID"));
                order.setTime(rs.getDate("ORDER_TIME"));
                order.setNumber(rs.getInt("NUMBER"));
                order.setPrice(rs.getDouble("PRICE"));
                order.setReceiver(rs.getString("RECEIVER"));
                order.setPhone(rs.getString("PHONE"));
                order.setAddress(rs.getString("ADDRESS"));
                order.setStatus(rs.getString("STATUS"));
                order.setUserId(rs.getInt("USER_ID"));
                order.setItemId(rs.getInt("ITEM_ID"));
                list.add(order);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
