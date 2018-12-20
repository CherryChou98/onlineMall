package onlineMall.web.dao;

import onlineMall.web.pojo.Shop;
import onlineMall.web.pojo.ShopKey;

public interface ShopDao {
    int deleteByPrimaryKey(ShopKey key);

    int insert(Shop record);

    int insertSelective(Shop record);

    Shop selectByPrimaryKey(ShopKey key);

    int updateByPrimaryKeySelective(Shop record);

    int updateByPrimaryKey(Shop record);
}