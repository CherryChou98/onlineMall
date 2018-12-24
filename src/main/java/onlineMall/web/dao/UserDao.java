package onlineMall.web.dao;

import onlineMall.web.pojo.User;
import onlineMall.web.pojo.UserKey;

public interface UserDao {

    /**
     * 用户登录
     * */
    public User userLogin(String userName, String password);

    /**
     * 管理员登录
     * */
    public User administratorLogin(String userName, String password);

    /**
     * 用户注册
     * */
    public boolean userRegister(User user);


    /*int deleteByPrimaryKey(UserKey key);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(UserKey key);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);*/
}