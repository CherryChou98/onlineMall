package onlineMall.web.dao.Impl;

import onlineMall.web.dao.Dbutil;
import onlineMall.web.dao.ForumTopicBackDao;
import onlineMall.web.pojo.ForumTopicBack;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author FT丶Kuroko
 * @date 2018/12/22 16:17
 */
@Repository
public class ForumTopicBackDaoImpl implements ForumTopicBackDao {

    private Dbutil dbutil;

    public ForumTopicBackDaoImpl(Dbutil dbutil) {
        this.dbutil = Dbutil.getInstance();
        try{
            dbutil.getConnection();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public int deleteByPrimaryKey(Integer forumTopicBackId) {
        String sql = "delete from forum_topic_back where FORUM_TOPIC_BACK_ID=?;";
        try{
            try(PreparedStatement pstat = dbutil.getConn().prepareStatement(sql)){
                pstat.setInt(1,forumTopicBackId);
                int i = pstat.executeUpdate();

                if(i>0){
                    System.out.println("删除成功");
                    return i;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int insert(ForumTopicBack record) {
        String sql = "insert into forum_topic_back(FORUM_TOPIC_BACK_ID,FORUM_TOPIC_ID,USER_ID,CONTENT,TIME,BACK_BACK) values(?,?,?,?,?,?);";
        try{
            try(PreparedStatement pstat = dbutil.getConn().prepareStatement(sql)){
                pstat.setInt(1,record.getForumTopicBackId());
                pstat.setInt(2,record.getForumTopicId());
                pstat.setInt(3,record.getUserId());
                pstat.setString(4,record.getContent());
                pstat.setDate(5, (Date) record.getTime());
                pstat.setInt(6,record.getBackBack());

                int i = pstat.executeUpdate();

                if(i>0){
                    System.out.println("插入成功");
                    return i;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int insertSelective(ForumTopicBack record) {
        return 0;
    }

    @Override
    public ForumTopicBack selectByPrimaryKey(Integer forumTopicBackId) {
        ForumTopicBack forumTopicBack = new ForumTopicBack();
        String sql = "select * from forum_topic_back where FORUM_TOPIC_BACK_ID=?;";
        try{
            try(PreparedStatement pstat = dbutil.getConn().prepareStatement(sql)){
                pstat.setInt(1,forumTopicBackId);
                ResultSet rs = pstat.executeQuery();
                if(rs.next()){
                    forumTopicBack.setForumTopicBackId(rs.getInt(1));
                    forumTopicBack.setForumTopicId(rs.getInt(2));
                    forumTopicBack.setUserId(rs.getInt(3));
                    forumTopicBack.setContent(rs.getString(4));
                    forumTopicBack.setTime(rs.getDate(5));
                    forumTopicBack.setBackBack(rs.getInt(6));
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return forumTopicBack;
    }

    @Override
    public int updateByPrimaryKeySelective(ForumTopicBack record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(ForumTopicBack record) {
        String sql = "update forum_topic_back set FORUM_TOPIC_ID=?,USER_ID=?,CONTENT=?,TIME=?,BACK_BACK=? where FORUM_TOPIC_BACK_ID=?;";
        try{
            try(PreparedStatement pstat = dbutil.getConn().prepareStatement(sql)){
                pstat.setInt(1,record.getForumTopicId());
                pstat.setInt(2,record.getUserId());
                pstat.setString(3,record.getContent());
                pstat.setDate(4, (Date) record.getTime());
                pstat.setInt(5,record.getBackBack());
                pstat.setInt(6,record.getForumTopicBackId());

                int i = pstat.executeUpdate();
                if(i>0){
                    System.out.println("更新成功");
                    return i;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }
}
