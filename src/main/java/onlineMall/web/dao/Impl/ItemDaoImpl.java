package onlineMall.web.dao.Impl;

import onlineMall.web.dao.Dbutil;
import onlineMall.web.dao.ItemDao;
import onlineMall.web.pojo.Item;
import onlineMall.web.pojo.ItemWithImage;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

/**
 * @ Package: onlineMall.web.dao.Impl
 * @ Author     ：linsola
 * @ Date       ：Created in 16:05 2018/12/21
 * @ Description：
 * @ Modified By：
 * @ Version:
 */
@Repository
public class ItemDaoImpl implements ItemDao {
    private Dbutil dbutil;

    public ItemDaoImpl(Dbutil dbutil) {
        this.dbutil = Dbutil.getInstance();
        try {
            dbutil.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<ItemWithImage> viewItemMessage(int shopId) {
        ArrayList<ItemWithImage> list = new ArrayList<>();
        String sql = "SELECT item.`ITEM_ID`, CATEGORY_ID, NAME, PRICE, DESCRIPTION, SHELF_TIME, SHOP_ID, STATE, image.`IMAGE_ID`, image.`IMAGE_URL`, image.`IMAGE_DESCRIPTION` FROM item, image WHERE item.`ITEM_ID` = image.`ITEM_ID` AND item.`SHOP_ID`= ?";
        try {
            ResultSet rs = dbutil.executeQuery(sql, shopId);
            while (rs.next()){
                ItemWithImage itemWithImage = new ItemWithImage();
                itemWithImage.setItemId(rs.getInt("ITEM_ID"));
                itemWithImage.setCategoryId(rs.getInt("CATEGORY_ID"));
                itemWithImage.setName(rs.getString("NAME"));
                itemWithImage.setPrice(rs.getDouble("PRICE"));
                itemWithImage.setDescription(rs.getString("DESCRIPTION"));
                itemWithImage.setShelfTime(rs.getDate("SHELF_TIME"));
                itemWithImage.setShopId(rs.getInt("SHOP_ID"));
                itemWithImage.setState(rs.getString("STATE"));
                itemWithImage.setImageId(rs.getInt("IMAGE_ID"));
                itemWithImage.setImageUrl(rs.getString("IMAGE_URL"));
                itemWithImage.setImageDescription(rs.getString("IMAGE_DESCRIPTION"));
                list.add(itemWithImage);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean insertItem(Item item) {
        int categoryId = item.getCategoryId();
        String name = item.getName();
        double price = item.getPrice();
        String description = item.getDescription();
        Date shelfTime = item.getShelfTime();
        int shopId = item.getShopId();
        String state = item.getState();
        boolean flag = false;
        String sql = "insert into item(ITEM_ID,CATEGORY_ID,NAME,PRICE,DESCRIPTION,SHELF_TIME,SHOP_ID,STATE) values (?,?,?,?,?,?,?,?)";
        try {
            int itemId = dbutil.countItem()+1;
            int r = dbutil.executeUpdate(sql,itemId,categoryId,name,price,description,shelfTime,shopId,state);
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
    public boolean insertImage(String imageUrl, int itemId, String imageDescription) {
        boolean flag = false;
        try {
            int imageId = dbutil.countImage()+1;
            String sql = "insert into image(IMAGE_ID,IMAGE_URL,ITEM_ID,IMAGE_DESCRIPTION) values (?,?,?,?)";
            int r = dbutil.executeUpdate(sql,imageId,imageUrl,itemId,imageDescription);
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
