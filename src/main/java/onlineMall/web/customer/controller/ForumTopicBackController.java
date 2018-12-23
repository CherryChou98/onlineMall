package onlineMall.web.customer.controller;

import onlineMall.web.dao.Impl.ForumTopicBackDaoImpl;
import onlineMall.web.pojo.ForumTopicBack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author FT丶Kuroko
 * @date 2018/12/22 16:38
 */
@Controller
@RequestMapping("/forumtopicback")
public class ForumTopicBackController {
    @Autowired
    private ForumTopicBackDaoImpl forumTopicBackDao;

    //显示指定帖子
    @RequestMapping(value = "/show",method = RequestMethod.POST)
    @ResponseBody
    public ForumTopicBack selectByPrimaryKey(@RequestParam("forumTopicBackId") Integer forumTopicBackId){
        ForumTopicBack forumTopicBack = forumTopicBackDao.selectByPrimaryKey(forumTopicBackId);
        return forumTopicBack;
    }
}
