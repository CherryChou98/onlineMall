package onlineMall.web.dao;

import onlineMall.web.pojo.Item;
import onlineMall.web.pojo.ItemWithImage;

import java.util.ArrayList;

public interface ItemDao {
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


   /* int deleteByPrimaryKey(Integer itemId);

    int insert(Item record);

    int insertSelective(Item record);

    Item selectByPrimaryKey(Integer itemId);

    int updateByPrimaryKeySelective(Item record);

    int updateByPrimaryKey(Item record);*/
}