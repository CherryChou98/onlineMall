package onlineMall.web.dao;

import onlineMall.web.pojo.Offuser;
import onlineMall.web.pojo.OffuserKey;

public interface OffuserDao {
    int deleteByPrimaryKey(OffuserKey key);

    int insert(Offuser record);

    int insertSelective(Offuser record);

    Offuser selectByPrimaryKey(OffuserKey key);

    int updateByPrimaryKeySelective(Offuser record);

    int updateByPrimaryKey(Offuser record);
}