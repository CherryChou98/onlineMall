package onlineMall.web.publicController;

import onlineMall.web.dao.Impl.CategoryDaoImpl;
import onlineMall.web.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

/**
 * @ Package: onlineMall.web.customer.controller
 * @ Author     ：linsola
 * @ Date       ：Created in 19:39 2018/12/20
 * @ Description：
 * @ Modified By：
 * @ Version:
 */
@Controller
public class PublicCategoryController {

    @Autowired
    private CategoryDaoImpl categoryDaoImpl;

    /**
     * 查看所有类别信息，测试成功，各模块复用
     * */
    @RequestMapping(value = "/category/queryAll", method = RequestMethod.GET)
    @ResponseBody
    public ArrayList<Category> queryAll(){
        ArrayList<Category> categories = categoryDaoImpl.queryAll();
        return categories;
    }
}
