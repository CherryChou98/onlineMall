package onlineMall.web.dao;

import onlineMall.web.pojo.Item;
import onlineMall.web.pojo.ItemWithCategory;
import onlineMall.web.pojo.ItemWithImage;

import java.util.ArrayList;

public interface ItemDao {
    /**
     * 查看商品信息，不含图片
     */
    public ArrayList<ItemWithCategory> viewItem(int shopId);
    /**
     * 商家查看商品信息，传入shopId，包含图片信息，类别信息，审核结果，
     * category表与item表与image表连接，对应的实体类为ItemWithImage
     * 待改动
     */
    public ArrayList<ItemWithImage> viewItemMessage(int shopId);
    /**
     * 根据类别查看商品信息，传入categoryId，包含图片信息，类别信息，审核结果，
     * category表与item表与image表连接，对应的实体类为ItemWithImage
     */
    public ArrayList<ItemWithImage> viewItemMessageByCategory(int categoryId);
    /**
     * 商家上传商品信息
     */
    public boolean insertItem(Item item);
    /**
     * 商家上传商品图片信息
     */
    public boolean insertImage(String imageUrl, int itemId, String imageDescription);
    /**
     * 商家删除商品信息，删除时删除image，offitem，shopping_cart表相关记录
     */
    public boolean deleteItemMessage(int itemId);
    /**
     * 商家搜索商品信息，按商品名检索，使用通配符
     */
    public ArrayList<Item> queryItem(String name);

    /**
     * 管理员审核商品信息，STATE字段由"0"变"1"
     */
    public boolean auditingItem(int itemId);


   /* int deleteByPrimaryKey(Integer itemId);

    int insert(Item record);

    int insertSelective(Item record);

    Item selectByPrimaryKey(Integer itemId);

    int updateByPrimaryKeySelective(Item record);

    int updateByPrimaryKey(Item record);*/
}