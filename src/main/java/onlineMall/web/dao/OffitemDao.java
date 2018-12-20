package onlineMall.web.dao;

import onlineMall.web.pojo.Offitem;
import onlineMall.web.pojo.OffitemKey;

public interface OffitemDao {
    int deleteByPrimaryKey(OffitemKey key);

    int insert(Offitem record);

    int insertSelective(Offitem record);

    Offitem selectByPrimaryKey(OffitemKey key);

    int updateByPrimaryKeySelective(Offitem record);

    int updateByPrimaryKey(Offitem record);
}