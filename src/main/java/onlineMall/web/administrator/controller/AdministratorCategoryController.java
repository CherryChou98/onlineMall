package onlineMall.web.administrator.controller;

import onlineMall.web.dao.Impl.CategoryDaoImpl;
import onlineMall.web.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @ Package: onlineMall.web.administrator.controller
 * @ Author     ：linsola
 * @ Date       ：Created in 14:30 2018/12/23
 * @ Description：
 * @ Modified By：
 * @ Version:
 */
@Controller
@ResponseBody
@RequestMapping("/administrator/category")
public class AdministratorCategoryController {
    @Autowired
    private CategoryDaoImpl categoryDaoImpl;

    /**
     * 添加商品分类，待测试
     * */
    @RequestMapping(value = "/insertCategory", method = RequestMethod.POST)
    public boolean insertCategory(@ModelAttribute Category category){
        boolean flag = categoryDaoImpl.insertCategory(category);
        return flag;
    }

    /**
     * 删除商品分类，测试成功
     * */
    @RequestMapping(value = "/deleteCategory", method = RequestMethod.GET)
    public boolean deleteCategory(@RequestParam("categoryId") int categoryId){
        boolean flag = categoryDaoImpl.deleteCategory(categoryId);
        return flag;
    }
}
