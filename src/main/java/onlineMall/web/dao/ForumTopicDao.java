package onlineMall.web.dao;

import onlineMall.web.pojo.ForumTopic;

import java.util.ArrayList;

public interface ForumTopicDao {

    /**
     * 删除帖子，管理员模块
     * */
    public boolean deleteForumTopic(int forumTopicId);

    /**
     * 插入帖子，论坛模块
     * */
    public boolean insertForumTopic(ForumTopic forumTopic);

    /**
     * 搜索帖子，根据内容查询，模糊匹配，管理员，论坛模块复用
     * */
    public ArrayList<ForumTopic> selectForumTopic(String content);

    /**
     * 查看所有帖子，管理员，论坛模块复用
     * */
    public ArrayList<ForumTopic> queryAllFormTopic();
}