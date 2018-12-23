package onlineMall.web.administrator.controller;

import onlineMall.web.dao.Impl.CommentItemDaoImpl;
import onlineMall.web.dao.Impl.ForumTopicDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ Package: onlineMall.web.administrator.controller
 * @ Author     ：linsola
 * @ Date       ：Created in 15:45 2018/12/23
 * @ Description：
 * @ Modified By：
 * @ Version:
 */
@Controller
@ResponseBody
@RequestMapping("/administrator")
public class ForumCommentController {
    @Autowired
    private ForumTopicDaoImpl forumTopicDaoImpl;

    @Autowired
    private CommentItemDaoImpl commentItemDaoImpl;

    /**
     * 删除帖子，测试成功
     * */
    @RequestMapping(value = "/deleteForumTopic", method = RequestMethod.GET)
    public boolean deleteForumTopic(@RequestParam("forumTopicId") int forumTopicId){
        boolean flag = forumTopicDaoImpl.deleteForumTopic(forumTopicId);
        return flag;
    }

    /**
     * 删除商品评论，测试成功
     */
    @RequestMapping(value = "/deleteItemComment",  method = RequestMethod.GET)
    public boolean deleteItemComment(@RequestParam("commentId") int commentId){
        boolean flag = commentItemDaoImpl.deleteItemComment(commentId);
        return flag;
    }

}
