package onlineMall.web.shop.controller;

import onlineMall.web.dao.Impl.CommentItemDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ Package: onlineMall.web.shop.controller
 * @ Author     ：linsola
 * @ Date       ：Created in 23:38 2018/12/21
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
     * 商家对用户评论进行回评，待测试
     */
    @RequestMapping(value = "/shopCommentBack",  method = RequestMethod.GET)
    public boolean shopCommentBack(@RequestParam("itemId")int itemId,@RequestParam("userId")int userId,@RequestParam("content")String content,@RequestParam("commentId")int commentId){
        boolean flag = commentItemDaoImpl.shopCommentBack(itemId, userId, content, commentId);
        return flag;
    }
}

