package onlineMall.web.dao;

import onlineMall.web.pojo.CommentItem;

public interface CommentItemDao {
    /**
     * 商家对用户评论进行回评
     */
    public boolean shopCommentBack(int itemId,int userId,String content,int commentId);

    /*int deleteByPrimaryKey(Integer commentId);

    int insert(CommentItem record);

    int insertSelective(CommentItem record);

    CommentItem selectByPrimaryKey(Integer commentId);

    int updateByPrimaryKeySelective(CommentItem record);

    int updateByPrimaryKey(CommentItem record);*/
}