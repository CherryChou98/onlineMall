package onlineMall.web.dao;

import onlineMall.web.pojo.ForumTopic;

public interface ForumTopicDao {

    /**
     * 删除帖子
     * */
    int deleteForumTopic(int forumTopicId);

    /**
     * 插入帖子
     * */
    int insertForumTopic(ForumTopic forumTopic);

    /**
     * 搜索帖子，根据内容查询，模糊匹配
     * */

    ForumTopic selectByPrimaryKey(Integer forumTopicId);

    int updateByPrimaryKeySelective(ForumTopic record);

    int updateByPrimaryKeyWithBLOBs(ForumTopic record);

    int updateByPrimaryKey(ForumTopic record);
}