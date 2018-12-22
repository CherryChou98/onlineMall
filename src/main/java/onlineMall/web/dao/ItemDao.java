package onlineMall.web.dao;

import onlineMall.web.pojo.Item;
import onlineMall.web.pojo.ItemWithImage;

import java.util.ArrayList;

public interface ItemDao {
    /**
     * 查看商品信息，不含图片
     */
    public ArrayList<Item> viewItem(int shopId);
    /**
     * 商家查看商品信息，包含图片信息，包含审核结果，item表与image表连接，对应的实体类ItemWithImage
     */
    public ArrayList<ItemWithImage> viewItemMessage(int shopId);
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
   /* int deleteByPrimaryKey(Integer itemId);

    int insert(Item record);

    int insertSelective(Item record);

    Item selectByPrimaryKey(Integer itemId);

    int updateByPrimaryKeySelective(Item record);

    int updateByPrimaryKey(Item record);*/
}