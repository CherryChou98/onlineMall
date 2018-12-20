package onlineMall.web.dao;

import onlineMall.web.pojo.ShoppingCart;

public interface ShoppingCartDao {
    int deleteByPrimaryKey(Integer shoppingCartId);

    int insert(ShoppingCart record);

    int insertSelective(ShoppingCart record);

    ShoppingCart selectByPrimaryKey(Integer shoppingCartId);

    int updateByPrimaryKeySelective(ShoppingCart record);

    int updateByPrimaryKey(ShoppingCart record);
}