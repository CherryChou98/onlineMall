package onlineMall.web.forumComment.controller;

import onlineMall.web.dao.Impl.ForumTopicDaoImpl;
import onlineMall.web.pojo.ForumTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * @ Package: onlineMall.web.forumComment.controller
 * @ Author     ：linsola
 * @ Date       ：Created in 17:20 2018/12/23
 * @ Description：
 * @ Modified By：
 * @ Version:
 */
@Controller
@ResponseBody
@RequestMapping("/forumTopic")
public class ForumTopicController {
    @Autowired
    private ForumTopicDaoImpl forumTopicDaoImpl;

    /**
     * 插入帖子，待测试
     */
    @RequestMapping(value = "/insertForumTopic",  method = RequestMethod.POST)
    public boolean insertForumTopic(@ModelAttribute ForumTopic forumTopic){
        boolean flag = forumTopicDaoImpl.insertForumTopic(forumTopic);
        return flag;
    }

    /**
     * 搜索帖子，测试成功，根据内容查询，模糊匹配，管理员，论坛模块复用
     */
    @RequestMapping(value = "/selectForumTopic",  method = RequestMethod.GET)
    public ArrayList<ForumTopic> selectForumTopic(@RequestParam("content") String content){
        String content1 = "%"+content+"%";
        ArrayList<ForumTopic> forumTopics = forumTopicDaoImpl.selectForumTopic(content1);
        return forumTopics;
    }

    /**
     * 查看所有帖子，测试成功，管理员，论坛模块复用
     * */
    @RequestMapping(value = "/queryAllFormTopic",  method = RequestMethod.GET)
    public ArrayList<ForumTopic> queryAllFormTopic(){
        ArrayList<ForumTopic> forumTopics = forumTopicDaoImpl.queryAllFormTopic();
        return forumTopics;
    }
}
