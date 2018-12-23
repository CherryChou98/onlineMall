package onlineMall.web.dao.Impl;

import onlineMall.web.dao.Dbutil;
import onlineMall.web.dao.ForumTopicDao;
import onlineMall.web.pojo.ForumTopic;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author FT丶Kuroko
 * @date 2018/12/22 15:40
 */
@Repository
public class ForumTopicDaoImpl implements ForumTopicDao {

    private Dbutil dbutil;

    public ForumTopicDaoImpl(Dbutil dbutil){
        this.dbutil = Dbutil.getInstance();
        try{
            dbutil.getConnection();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public int deleteForumTopic(int forumTopicId) {
        String sql = "delete from forum_topic where FORUM_TOPIC_ID=?;";
        try{
            try(PreparedStatement pstat = dbutil.getConn().prepareStatement(sql)) {
                pstat.setInt(1,forumTopicId);
                int i = pstat.executeUpdate();

                if(i>0){
                    System.out.println("删除成功");
                    return i;
                }
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int insertForumTopic(ForumTopic record) {
        String sql = "insert into forum_topic(FORUM_TOPIC_ID,USER_ID,TITLE,CONTENT,TIME) values(?,?,?,?,?);";
        try{
            try(PreparedStatement pstat = dbutil.getConn().prepareStatement(sql)){
                pstat.setInt(1,record.getForumTopicId());
                pstat.setInt(2,record.getUserId());
                pstat.setString(3,record.getTitle());
                pstat.setString(4,record.getContent());
                pstat.setDate(5, (Date) record.getTime());

                int i = pstat.executeUpdate();

                if(i>0){
                    System.out.println("插入成功");
                    return i;
                }
            }
        } catch (SQLException e) {
                e.printStackTrace();
            }
            return 0;
        }

    @Override
    public ForumTopic selectByPrimaryKey(Integer forumTopicId) {
        ForumTopic forumTopic = new ForumTopic();
        String sql = "select * from forum_topic where FORUM_TOPIC_ID=?;";
        try{
            try(PreparedStatement pstat = dbutil.getConn().prepareStatement(sql)){
                pstat.setInt(1,forumTopicId);
                ResultSet rs = pstat.executeQuery();
                if(rs.next()){
                    forumTopic.setForumTopicId(rs.getInt(1));
                    forumTopic.setUserId(rs.getInt(2));
                    forumTopic.setTitle(rs.getString(3));
                    forumTopic.setContent(rs.getString(4));
                    forumTopic.setTime(rs.getDate(5));
                }
            }
        } catch (SQLException e) {
                e.printStackTrace();
            }
            return forumTopic;
    }

    @Override
    public int updateByPrimaryKeySelective(ForumTopic record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeyWithBLOBs(ForumTopic record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(ForumTopic record) {
        String sql = "update forum_topic set USER_ID=?,TITLE=?,CONTENT=?,TIME=? where FORUM_TOPIC_ID=?;";
        try{
            try(PreparedStatement pstat = dbutil.getConn().prepareStatement(sql)){
                pstat.setInt(1,record.getUserId());
                pstat.setString(2,record.getTitle());
                pstat.setString(3,record.getContent());
                pstat.setDate(4, (Date) record.getTime());
                pstat.setInt(5,record.getForumTopicId());

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

    public ArrayList<ForumTopic> selecctAllForumTopic(){
        ArrayList<ForumTopic> list = new ArrayList<>();
        String sql = "select * from forum_topic;";
        try{
            ResultSet rs = dbutil.executeQuery(sql);
            while (rs.next()){
                ForumTopic forumTopic = new ForumTopic();
                forumTopic.setForumTopicId(rs.getInt(1));
                forumTopic.setUserId(rs.getInt(2));
                forumTopic.setTitle(rs.getString(3));
                forumTopic.setContent(rs.getString(4));
                forumTopic.setTime(rs.getDate(5));
                list.add(forumTopic);
            }
            return list;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
