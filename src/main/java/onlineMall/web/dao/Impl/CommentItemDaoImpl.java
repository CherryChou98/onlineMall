package onlineMall.web.dao.Impl;

import onlineMall.web.dao.CommentItemDao;
import onlineMall.web.dao.Dbutil;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * @ Package: onlineMall.web.dao.Impl
 * @ Author     ：linsola
 * @ Date       ：Created in 23:10 2018/12/21
 * @ Description：
 * @ Modified By：
 * @ Version:
 */
@Repository
public class CommentItemDaoImpl implements CommentItemDao {
    private Dbutil dbutil;

    public CommentItemDaoImpl(Dbutil dbutil) {
        this.dbutil = Dbutil.getInstance();
        try {
            dbutil.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public boolean commentItemBack(int itemId,int userId,String content,int commentId) {
        boolean flag = false;
        Date date = new Date();
        try {
            int ct = dbutil.countCommentItem()+1;
            String sql = "INSERT INTO comment_item(COMMENT_ID,ITEM_ID,USER_ID,CONTENT,TIME,BACK_BACK) VALUES(?,?,?,?,?,?)";
            int r = dbutil.executeUpdate(sql,ct,itemId,userId,content,date,commentId);
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

    @Override
    public boolean deleteItemComment(int commentId) {
        boolean flag = false;
        String sql = "DELETE FROM comment_item WHERE COMMENT_ID=?";
        try {
            int r = dbutil.executeUpdate(sql,commentId);
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
