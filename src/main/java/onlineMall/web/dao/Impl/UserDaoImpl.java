package onlineMall.web.dao.Impl;

import onlineMall.web.dao.Dbutil;
import onlineMall.web.dao.UserDao;
import onlineMall.web.pojo.User;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;

/**
 * @ Package: onlineMall.web.dao.Impl
 * @ Author     ：linsola
 * @ Date       ：Created in 22:23 2018/12/23
 * @ Description：
 * @ Modified By：
 * @ Version:
 */
@Repository
public class UserDaoImpl implements UserDao {

    private Dbutil dbutil;

    public UserDaoImpl(Dbutil dbutil) {
        this.dbutil = Dbutil.getInstance();
        try {
            dbutil.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public User userLogin(String userName, String password) {
        User user = new User();
        String sql = "SELECT USER_ID,USER_NAME,PASSWORD,NAME,EMAIL,PHONE,BIRTHDAY,SEX,TYPE FROM USER WHERE USER_NAME=? AND PASSWORD=?";
        try {
            ResultSet rs = dbutil.executeQuery(sql,userName,password);
            while (rs.next()){
                if("0".equals(rs.getString("TYPE"))){
                    user.setUserId(rs.getInt("USER_ID"));
                    user.setUserName(rs.getString("USER_NAME"));
                    user.setPassword(rs.getString("PASSWORD"));
                    user.setName(rs.getString("NAME"));
                    user.setEmail(rs.getString("EMAIL"));
                    user.setPhone(rs.getString("PHONE"));
                    user.setBirthday(rs.getDate("BIRTHDAY"));
                    user.setSex(rs.getString("SEX"));
                    user.setType(rs.getString("TYPE"));
                    return user;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User administratorLogin(String userName, String password) {
        User user = new User();
        String sql = "SELECT USER_ID,USER_NAME,PASSWORD,NAME,EMAIL,PHONE,BIRTHDAY,SEX,TYPE FROM USER WHERE USER_NAME=? AND PASSWORD=?";
        try {
            ResultSet rs = dbutil.executeQuery(sql,userName,password);
            while (rs.next()){
                if("1".equals(rs.getString("TYPE"))){
                    user.setUserId(rs.getInt("USER_ID"));
                    user.setUserName(rs.getString("USER_NAME"));
                    user.setPassword(rs.getString("PASSWORD"));
                    user.setName(rs.getString("NAME"));
                    user.setEmail(rs.getString("EMAIL"));
                    user.setPhone(rs.getString("PHONE"));
                    user.setBirthday(rs.getDate("BIRTHDAY"));
                    user.setSex(rs.getString("SEX"));
                    user.setType(rs.getString("TYPE"));
                    return user;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean userRegister(User user) {
        boolean flag = false;
        String sql = "INSERT INTO USER (USER_ID,USER_NAME,PASSWORD,NAME,EMAIL,PHONE,BIRTHDAY,SEX,TYPE) VALUES(?,?,?,?,?,?,?,?,?)";
        try {
            int userId = dbutil.countUser()+1;
            int r = dbutil.executeUpdate(sql,userId,user.getUserName(),user.getPassword(),user.getName(),user.getEmail(),user.getPhone(),user.getBirthday(),user.getSex(),user.getType());
            if(r!=0){
                flag = true;
            }else {
                flag = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

}
