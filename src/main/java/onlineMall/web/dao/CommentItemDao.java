package onlineMall.web.dao;

import onlineMall.web.pojo.CommentItem;

public interface CommentItemDao {
    int deleteByPrimaryKey(Integer commentId);

    int insert(CommentItem record);

    int insertSelective(CommentItem record);

    CommentItem selectByPrimaryKey(Integer commentId);

    int updateByPrimaryKeySelective(CommentItem record);

    int updateByPrimaryKey(CommentItem record);
}