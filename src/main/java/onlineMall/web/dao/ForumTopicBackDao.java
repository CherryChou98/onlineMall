package onlineMall.web.dao;

import onlineMall.web.pojo.ForumTopicBack;

public interface ForumTopicBackDao {
    int deleteByPrimaryKey(Integer forumTopicBackId);

    int insert(ForumTopicBack record);

    int insertSelective(ForumTopicBack record);

    ForumTopicBack selectByPrimaryKey(Integer forumTopicBackId);

    int updateByPrimaryKeySelective(ForumTopicBack record);

    int updateByPrimaryKey(ForumTopicBack record);
}