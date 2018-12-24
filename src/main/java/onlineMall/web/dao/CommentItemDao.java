package onlineMall.web.dao;

public interface CommentItemDao {
    /**
     * 评论商品，对商品评论进行回评
     */
    public boolean commentItemBack(int itemId,int userId,String content,int commentId);

    /**
     * 删除商品评论
     */
    public boolean deleteItemComment(int commentId);

    /*int deleteByPrimaryKey(Integer commentId);

    int insert(CommentItem record);

    int insertSelective(CommentItem record);

    CommentItem selectByPrimaryKey(Integer commentId);

    int updateByPrimaryKeySelective(CommentItem record);

    int updateByPrimaryKey(CommentItem record);*/
}