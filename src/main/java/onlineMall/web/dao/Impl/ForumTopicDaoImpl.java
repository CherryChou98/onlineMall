package onlineMall.web.dao.Impl;

import onlineMall.web.dao.Dbutil;
import onlineMall.web.dao.ForumTopicDao;
import onlineMall.web.pojo.ForumTopic;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * @ Package: onlineMall.web.dao.Impl
 * @ Author     ：linsola
 * @ Date       ：Created in 16:51 2018/12/23
 * @ Description：
 * @ Modified By：
 * @ Version:
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
    public boolean deleteForumTopic(int forumTopicId) {
        boolean flag = false;
        String sql = "DELETE FROM forum_topic WHERE FORUM_TOPIC_ID=?";
        try {
            int r = dbutil.executeUpdate(sql,forumTopicId);
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
    public boolean insertForumTopic(ForumTopic forumTopic) {
        boolean flag = false;
        String sql = "insert into forum_topic(FORUM_TOPIC_ID,USER_ID,TITLE,CONTENT,TIME) values(?,?,?,?,?)";
        try {
            int r = dbutil.executeUpdate(sql,forumTopic.getForumTopicId(),forumTopic.getUserId(),forumTopic.getTitle(),forumTopic.getContent(),forumTopic.getTime());
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
    public ArrayList<ForumTopic> selectForumTopic(String content) {
        ArrayList<ForumTopic> list = new ArrayList<>();
        String sql = "SELECT FORUM_TOPIC_ID,USER_ID,TITLE,CONTENT,TIME FROM forum_topic WHERE CONTENT LIKE ?";
        try {
            ResultSet rs = dbutil.executeQuery(sql,content);
            while (rs.next()){
                ForumTopic forumTopic = new ForumTopic();
                forumTopic.setForumTopicId(rs.getInt("FORUM_TOPIC_ID"));
                forumTopic.setUserId(rs.getInt("USER_ID"));
                forumTopic.setTitle(rs.getString("TITLE"));
                forumTopic.setContent(rs.getString("CONTENT"));
                forumTopic.setTime(rs.getDate("TIME"));
                list.add(forumTopic);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<ForumTopic> queryAllFormTopic() {
        ArrayList<ForumTopic> list = new ArrayList<>();
        String sql = "SELECT FORUM_TOPIC_ID,USER_ID,TITLE,CONTENT,TIME FROM forum_topic";
        try {
            ResultSet rs = dbutil.executeQuery(sql);
            while (rs.next()){
                ForumTopic forumTopic = new ForumTopic();
                forumTopic.setForumTopicId(rs.getInt("FORUM_TOPIC_ID"));
                forumTopic.setUserId(rs.getInt("USER_ID"));
                forumTopic.setTitle(rs.getString("TITLE"));
                forumTopic.setContent(rs.getString("CONTENT"));
                forumTopic.setTime(rs.getDate("TIME"));
                list.add(forumTopic);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
