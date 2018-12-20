package onlineMall.web.dao;

import onlineMall.web.pojo.Offshop;
import onlineMall.web.pojo.OffshopKey;

public interface OffshopDao {
    int deleteByPrimaryKey(OffshopKey key);

    int insert(Offshop record);

    int insertSelective(Offshop record);

    Offshop selectByPrimaryKey(OffshopKey key);

    int updateByPrimaryKeySelective(Offshop record);

    int updateByPrimaryKey(Offshop record);
}