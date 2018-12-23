package onlineMall.web.customer.controller;

import onlineMall.web.dao.Impl.ForumTopicDaoImpl;
import onlineMall.web.pojo.ForumTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

/**
 * @author FT丶Kuroko
 * @date 2018/12/22 16:09
 */
@Controller
@RequestMapping("/forumtopic")
public class ForumTopicController {

    @Autowired
    private ForumTopicDaoImpl forumTopicDao;

    //查询所有帖子
    @RequestMapping(value = "/showAllTopic",method = RequestMethod.POST)
    @ResponseBody
    public ArrayList<ForumTopic> selectAllForumTopic(){
        ArrayList<ForumTopic> list = forumTopicDao.selecctAllForumTopic();
        return list;
    }

    //查询指定帖子
    @RequestMapping(value = "/showTopic",method = RequestMethod.POST)
    @ResponseBody
    public ForumTopic selectForumTopicByPrimaryKey(@RequestParam("forumId") Integer forum_id){
        ForumTopic forumTopic = forumTopicDao.selectByPrimaryKey(forum_id);
        return forumTopic;
    }
}
