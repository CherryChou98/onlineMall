package onlineMall.web.dao.Impl;

import onlineMall.web.dao.Dbutil;
import onlineMall.web.dao.ShopDao;
import onlineMall.web.pojo.Shop;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;

/**
 * @ Package: onlineMall.web.dao.Impl
 * @ Author     ：linsola
 * @ Date       ：Created in 1:02 2018/12/24
 * @ Description：
 * @ Modified By：
 * @ Version:
 */
@Repository
public class ShopDaoImpl implements ShopDao {
    private Dbutil dbutil;

    public ShopDaoImpl(Dbutil dbutil) {
        this.dbutil = Dbutil.getInstance();
        try {
            dbutil.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Shop shopLogin(String shopName, String password) {
        Shop shop = new Shop();
        String sql = "SELECT SHOP_ID,SHOP_NAME,PASSWORD,EMAIL,PHONE,OWNER_NAME FROM shop WHERE SHOP_NAME=? AND PASSWORD=?";
        try {
            ResultSet rs = dbutil.executeQuery(sql,shopName,password);
            while (rs.next()){
                shop.setShopId(rs.getInt("SHOP_ID"));
                shop.setShopName(rs.getString("SHOP_NAME"));
                shop.setPassword(rs.getString("PASSWORD"));
                shop.setEmail(rs.getString("EMAIL"));
                shop.setPhone(rs.getString("PHONE"));
                shop.setOwnerName(rs.getString("OWNER_NAME"));
            }
            return shop;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean shopRegister(Shop shop) {
        boolean flag = false;
        String sql = "INSERT INTO shop (SHOP_ID,SHOP_NAME,PASSWORD,EMAIL,PHONE,OWNER_NAME) VALUES(?,?,?,?,?,?)";
        try {
            int shopId = dbutil.countShop()+1;
            int r = dbutil.executeUpdate(sql,shopId,shop.getShopName(),shop.getPassword(),shop.getEmail(),shop.getPhone(),shop.getOwnerName());
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
