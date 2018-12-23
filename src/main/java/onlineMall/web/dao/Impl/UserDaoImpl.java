package onlineMall.web.dao.Impl;

import onlineMall.web.dao.Dbutil;
import onlineMall.web.dao.UserDao;
import onlineMall.web.pojo.User;
import onlineMall.web.pojo.UserKey;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author FT丶Kuroko
 * @date 2018/12/21 20:25
 */
@Repository
public class UserDaoImpl implements UserDao {

    private Dbutil dbutil;

    public UserDaoImpl(Dbutil dbutil){
        this.dbutil = Dbutil.getInstance();
        try{
            dbutil.getConnection();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public int deleteByPrimaryKey(UserKey key) {
        return 0;
    }

    //插入用户
    @Override
    public int insert(User record) {
        User user = new User();
        String sql = "insert into user (USER_ID,USER_NAME,_PASSWORD,NAME,EMAIL,PHONE,BIRTHDAY,SEX,TYPE) values(?,?,?,?,?,?,?,?,?);";
        try{
            try(PreparedStatement pstat = dbutil.getConn().prepareStatement(sql)){
                pstat.setInt(1,user.getUserId());
                pstat.setString(2,user.getUserName());
                pstat.setString(3,user.getPassword());
                pstat.setString(4,user.getName());
                pstat.setString(5,user.getEmail());
                pstat.setString(6,user.getPhone());
                pstat.setDate(7, (Date) user.getBirthday());
                pstat.setString(8,user.getSex());
                pstat.setString(9,user.getType());

                int i = pstat.executeUpdate();

                if(i>0){
                    System.out.println("插入成功");
                    return 1;
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int insertSelective(User record) {
        return 0;
    }

    //根据用户名或用户id查询用户信息
    @Override
    public User selectByPrimaryKey(UserKey key) {
        User user = new User();
        String sql = "select * from usr where";
        if (key.getUserName() == null)
            sql += "USER_ID=?;";
        else
            sql += "USERNAME=?;";

        try {
            try (PreparedStatement pstat = dbutil.getConn().prepareStatement(sql)) {
                if (key.getUserName() == null)
                    pstat.setInt(1, key.getUserId());
                else
                    pstat.setString(1, key.getUserName());
                ResultSet rs = pstat.executeQuery();

                if (rs.next()) {
                    user.setUserId(rs.getInt(1));
                    user.setUserName(rs.getString(2));
                    user.setPassword(rs.getString(3));
                    user.setName(rs.getString(4));
                    user.setEmail(rs.getString(5));
                    user.setPhone(rs.getString(6));
                    user.setBirthday(rs.getDate(7));
                    user.setSex(rs.getString(8));
                    user.setType(rs.getString(9));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public int updateByPrimaryKeySelective(User record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(User record) {
        return 0;
    }

    //查询所有用户信息
    public ArrayList<User> getAllUser(){
        ArrayList<User> list = new ArrayList<>();

        try{
            String sql = "select * from user";
            ResultSet rs = dbutil.executeQuery(sql);

            while(rs.next()){
                User user = new User();
                user.setUserId(rs.getInt(1));
                user.setUserName(rs.getString(2));
                user.setPassword(rs.getString(3));
                user.setName(rs.getString(4));
                user.setEmail(rs.getString(5));
                user.setPhone(rs.getString(6));
                user.setBirthday(rs.getDate(7));
                user.setSex(rs.getString(8));
                user.setType(rs.getString(9));
                list.add(user);
            }
            return list;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    //更新用户状态
    public boolean updateType(User user){
        String sql = "update user set TYPE = 1 where USER_ID = ?";
        try{
            try(PreparedStatement pstat = dbutil.getConn().prepareStatement(sql)){
                pstat.setInt(1,user.getUserId());
                int i = pstat.executeUpdate();
                if(i>0){
                    return true;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public User login(String username, String password){
        String sql = "select * from user where username=? and password=?";
        User user = new User();
        try{
            try(PreparedStatement pstat = dbutil.getConn().prepareStatement(sql)){
                pstat.setString(1,username);
                pstat.setString(2,password);
                ResultSet rs = pstat.executeQuery();
                if(rs.next()){
                    user.setUserId(rs.getInt(1));
                    user.setUserName(rs.getString(2));
                    user.setPassword(rs.getString(3));
                    user.setName(rs.getString(4));
                    user.setEmail(rs.getString(5));
                    user.setPhone(rs.getString(6));
                    user.setBirthday(rs.getDate(7));
                    user.setSex(rs.getString(8));
                    user.setType(rs.getString(9));
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }

}

