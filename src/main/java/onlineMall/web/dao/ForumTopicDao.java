package onlineMall.web.dao;

import onlineMall.web.pojo.ForumTopic;

public interface ForumTopicDao {
    int deleteByPrimaryKey(Integer forumTopicId);

    int insert(ForumTopic record);

    int insertSelective(ForumTopic record);

    ForumTopic selectByPrimaryKey(Integer forumTopicId);

    int updateByPrimaryKeySelective(ForumTopic record);

    int updateByPrimaryKeyWithBLOBs(ForumTopic record);

    int updateByPrimaryKey(ForumTopic record);
}