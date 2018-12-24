package onlineMall.web.forumComment.controller;

import onlineMall.web.dao.Impl.CommentItemDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ Package: onlineMall.web.forumComment.controller
 * @ Author     ：linsola
 * @ Date       ：Created in 16:05 2018/12/23
 * @ Description：
 * @ Modified By：
 * @ Version:
 */
@Controller
@ResponseBody
@RequestMapping("/commentItem")
public class CommentItemController {
    @Autowired
    private CommentItemDaoImpl commentItemDaoImpl;

    /**
     * 评论商品，对商品评论进行回评，待测试
     */
    @RequestMapping(value = "/itemCommentBack",  method = RequestMethod.GET)
    public boolean itemCommentBack(@RequestParam("itemId")int itemId, @RequestParam("userId")int userId, @RequestParam("content")String content, @RequestParam("commentId")int commentId){
        boolean flag = commentItemDaoImpl.commentItemBack(itemId, userId, content, commentId);
        return flag;
    }

}
