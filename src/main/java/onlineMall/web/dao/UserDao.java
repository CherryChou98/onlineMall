package onlineMall.web.dao;

import onlineMall.web.pojo.User;
import onlineMall.web.pojo.UserKey;

public interface UserDao {
    int deleteByPrimaryKey(UserKey key);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(UserKey key);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}