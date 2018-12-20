package onlineMall.web.customer.controller;

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
@RequestMapping("/text")
public class TextController {

    @Autowired
    private CategoryDaoImpl categoryDaoImpl;

    @RequestMapping(value = "/find", method = RequestMethod.GET)
    @ResponseBody
    public ArrayList<Category> findAllCategory(){
        ArrayList<Category> c = categoryDaoImpl.queryAll();
        return c;
    }
}
