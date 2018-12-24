package onlineMall.web.dao.Impl;

import onlineMall.web.dao.Dbutil;
import onlineMall.web.dao.ItemDao;
import onlineMall.web.pojo.Item;
import onlineMall.web.pojo.ItemWithCategory;
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
    public ArrayList<ItemWithCategory> viewItem(int shopId) {
        ArrayList<ItemWithCategory> list = new ArrayList<>();
        String sql = "SELECT ITEM_ID,item.CATEGORY_ID,category.NAME AS NAME1,item.NAME,PRICE,DESCRIPTION,SHELF_TIME,SHOP_ID,STATE FROM item,category WHERE item.CATEGORY_ID=category.CATEGORY_ID AND item.`SHOP_ID`=?";
        try {
            ResultSet rs = dbutil.executeQuery(sql, shopId);
            while (rs.next()){
                ItemWithCategory itemWithCategory = new ItemWithCategory();
                String state = null;
                itemWithCategory.setItemId(rs.getInt("ITEM_ID"));
                itemWithCategory.setCategoryId(rs.getInt("CATEGORY_ID"));
                itemWithCategory.setName1(rs.getString("NAME1"));
                itemWithCategory.setName(rs.getString("NAME"));
                itemWithCategory.setPrice(rs.getDouble("PRICE"));
                itemWithCategory.setDescription(rs.getString("DESCRIPTION"));
                itemWithCategory.setShelfTime(rs.getDate("SHELF_TIME"));
                itemWithCategory.setShopId(rs.getInt("SHOP_ID"));
                if("0".equals(rs.getString("STATE"))){
                    state = "未审核通过";
                }else {
                    state = "审核通过";
                }
                itemWithCategory.setState(state);
                list.add(itemWithCategory);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<ItemWithImage> viewItemMessage(int shopId) {
        ArrayList<ItemWithImage> list = new ArrayList<>();
        String sql = "SELECT item.`ITEM_ID`, item.CATEGORY_ID,category.`NAME` AS NAME1, item.NAME, PRICE, DESCRIPTION, SHELF_TIME, SHOP_ID, STATE, image.`IMAGE_ID`, image.`IMAGE_URL`, image.`IMAGE_DESCRIPTION` FROM item,category,image WHERE item.`CATEGORY_ID`=category.`CATEGORY_ID` AND item.`ITEM_ID` = image.`ITEM_ID` AND item.`SHOP_ID`= ?";
        try {
            ResultSet rs = dbutil.executeQuery(sql, shopId);
            while (rs.next()){
                ItemWithImage itemWithImage = new ItemWithImage();
                String state = null;
                itemWithImage.setItemId(rs.getInt("ITEM_ID"));
                itemWithImage.setCategoryId(rs.getInt("CATEGORY_ID"));
                itemWithImage.setName1(rs.getString("NAME1"));
                itemWithImage.setName(rs.getString("NAME"));
                itemWithImage.setPrice(rs.getDouble("PRICE"));
                itemWithImage.setDescription(rs.getString("DESCRIPTION"));
                itemWithImage.setShelfTime(rs.getDate("SHELF_TIME"));
                itemWithImage.setShopId(rs.getInt("SHOP_ID"));
                if("0".equals(rs.getString("STATE"))){
                    state = "未审核通过";
                }else {
                    state = "审核通过";
                }
                itemWithImage.setState(state);
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
    public ArrayList<ItemWithImage> viewItemMessageByCategory(int categoryId) {
        ArrayList<ItemWithImage> list = new ArrayList<>();
        String sql = "SELECT item.`ITEM_ID`, item.CATEGORY_ID,category.`NAME` AS NAME1, item.NAME, PRICE, DESCRIPTION, SHELF_TIME, SHOP_ID, STATE, image.`IMAGE_ID`, image.`IMAGE_URL`, image.`IMAGE_DESCRIPTION` FROM item,category,image WHERE item.`CATEGORY_ID`=category.`CATEGORY_ID` AND item.`ITEM_ID` = image.`ITEM_ID` AND category.`CATEGORY_ID`=?";
        try {
            ResultSet rs = dbutil.executeQuery(sql, categoryId);
            while (rs.next()){
                ItemWithImage itemWithImage = new ItemWithImage();
                String state = null;
                itemWithImage.setItemId(rs.getInt("ITEM_ID"));
                itemWithImage.setCategoryId(rs.getInt("CATEGORY_ID"));
                itemWithImage.setName1(rs.getString("NAME1"));
                itemWithImage.setName(rs.getString("NAME"));
                itemWithImage.setPrice(rs.getDouble("PRICE"));
                itemWithImage.setDescription(rs.getString("DESCRIPTION"));
                itemWithImage.setShelfTime(rs.getDate("SHELF_TIME"));
                itemWithImage.setShopId(rs.getInt("SHOP_ID"));
                if("0".equals(rs.getString("STATE"))){
                    state = "未审核通过";
                }else {
                    state = "审核通过";
                }
                itemWithImage.setState(state);
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
        String state = "0";
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
        String sql = "insert into image(IMAGE_ID,IMAGE_URL,ITEM_ID,IMAGE_DESCRIPTION) values (?,?,?,?)";
        if(itemId==0){
            try {
                int ct = dbutil.countItem();
                int imageId = dbutil.countImage()+1;
                int r = dbutil.executeUpdate(sql,imageId,imageUrl,ct,imageDescription);
                if(r!=0){
                    flag = true;
                }else {
                    flag = false;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {
            try {
                int imageId = dbutil.countImage()+1;
                int r = dbutil.executeUpdate(sql,imageId,imageUrl,itemId,imageDescription);
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
    public boolean deleteItemMessage(int itemId) {
        boolean flag = false;
        String sql = "DELETE FROM image WHERE ITEM_Id=?";
        String sqla = "SELECT ITEM_Id FROM image WHERE ITEM_Id=?";
        String sql1 = "DELETE FROM offitem WHERE ITEM_Id=?";
        String sql1a = "SELECT ITEM_Id FROM offitem WHERE ITEM_Id=?";
        String sql3 = "DELETE FROM item WHERE ITEM_Id=?";
        try {
            ResultSet rs = dbutil.executeQuery(sqla,itemId);
            if(rs.next()){
                dbutil.executeUpdate(sql,itemId);
            }
            ResultSet rs1 = dbutil.executeQuery(sql1a,itemId);
            if(rs1.next()){
                dbutil.executeUpdate(sql1,itemId);
            }
            int r = dbutil.executeUpdate(sql3,itemId);
            if(r!=0){
                flag = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public ArrayList<Item> queryItem(String name) {
        String sql = "SELECT ITEM_ID,CATEGORY_ID,NAME,PRICE,DESCRIPTION,SHELF_TIME,SHOP_ID,STATE FROM item WHERE name LIKE ?";
        ArrayList<Item> list = new ArrayList<>();
        try {
            ResultSet rs = dbutil.executeQuery(sql,name);
            while (rs.next()){
                Item item = new Item();
                String state = null;
                item.setItemId(rs.getInt("ITEM_ID"));
                item.setCategoryId(rs.getInt("CATEGORY_ID"));
                item.setName(rs.getString("NAME"));
                item.setPrice(rs.getDouble("PRICE"));
                item.setDescription(rs.getString("DESCRIPTION"));
                item.setShelfTime(rs.getDate("SHELF_TIME"));
                item.setShopId(rs.getInt("SHOP_ID"));
                if("0".equals(rs.getString("STATE"))){
                    state = "未审核通过";
                }else {
                    state = "审核通过";
                }
                item.setState(state);
                list.add(item);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean auditingItem(int itemId) {
        boolean flag = false;
        String sql = "UPDATE item SET STATE=\"1\" WHERE ITEM_ID=?";
        try {
            int r = dbutil.executeUpdate(sql,itemId);
            if(r!=0){
                flag = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }
}
