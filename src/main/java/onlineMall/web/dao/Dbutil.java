package onlineMall.web.dao;

import org.springframework.stereotype.Repository;

import java.sql.*;

/**
 * @ Package: bookstore.web.dao
 * @ Author     ：linsola
 * @ Date       ：Created in 14:54 2018/11/28
 * @ Description：
 * @ Modified By：
 * @ Version:
 */
@Repository
public class Dbutil {
    public static final String DRIVER = "com.mysql.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/online_mall?characterEncoding=utf-8";
    public static final String USER = "root";
    public static final String PASSWORD = "123456";
    private static Connection conn = null;

    private static Dbutil ourInstance = new Dbutil();

    public static Dbutil getInstance() {
        return ourInstance;
    }

    private Dbutil() {
    }

    public Connection getConn() {
        return conn;
    }

    public void getConnection() throws Exception {
        Class.forName(DRIVER);
        conn = DriverManager.getConnection(URL,USER,PASSWORD);
    }

    public void closeConnection() throws Exception {
        if(conn!=null&&conn.isClosed()){
            conn.close();
            conn = null;
        }
    }

    public int executeUpdate(String sql) throws Exception {
        Statement st = conn.createStatement();
        int r = st.executeUpdate(sql);
        return r;
    }

    public int executeUpdate(String sql, Object...obj) throws Exception {
        PreparedStatement pst = conn.prepareStatement(sql);
        if(obj!=null&&obj.length>0){
            for(int i=0;i<obj.length;i++){
                pst.setObject(i+1,obj[i]);
            }
        }
        int r = pst.executeUpdate();
        return r;
    }

    public ResultSet executeQuery(String sql) throws Exception {
        PreparedStatement pst = conn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        return rs;
    }

    public ResultSet executeQuery(String sql, Object...obj) throws Exception {
        PreparedStatement pst = conn.prepareStatement(sql);
        if(obj!=null&&obj.length>0){
            for(int i=0;i<obj.length;i++){
                pst.setObject(i+1,obj[i]);
            }
        }
        ResultSet rs = pst.executeQuery();
        return rs;
    }

    public int countUser() throws Exception{
        String sql = "SELECT MAX(USER_ID) AS ct FROM user ";
        PreparedStatement pst = conn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        if(rs.next()){
            int r = rs.getInt("ct");
            return r;
        }else{
            return 0;
        }
    }

    public int countShop() throws Exception{
        String sql = "SELECT MAX(SHOP_ID) AS ct FROM shop ";
        PreparedStatement pst = conn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        if(rs.next()){
            int r = rs.getInt("ct");
            return r;
        }else{
            return 0;
        }
    }

    public int countImage() throws Exception{
        String sql = "SELECT MAX(IMAGE_ID) AS ct FROM image ";
        PreparedStatement pst = conn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        if(rs.next()){
            int r = rs.getInt("ct");
            return r;
        }else{
            return 0;
        }
    }

    public int countItem() throws Exception{
        String sql = "SELECT MAX(ITEM_ID) AS ct FROM item ";
        PreparedStatement pst = conn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        if(rs.next()){
            int r = rs.getInt("ct");
            return r;
        }else{
            return 0;
        }
    }

    public int countCommentItem() throws Exception{
        String sql = "SELECT MAX(COMMENT_ID) AS ct FROM comment_item ";
        PreparedStatement pst = conn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        if(rs.next()){
            int r = rs.getInt("ct");
            return r;
        }else{
            return 0;
        }
    }

    public int countOrder() throws Exception{
        String sql = "SELECT MAX(ORDER_ID) AS ct FROM orders ";
        PreparedStatement pst = conn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        if(rs.next()){
            int r = rs.getInt("ct");
            return r;
        }else{
            return 0;
        }
    }
}
