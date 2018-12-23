package onlineMall.web.dao;

import onlineMall.web.pojo.Category;

import java.util.ArrayList;

public interface CategoryDao {

    /**
     * 查询所有类别
     * */
    public ArrayList<Category> queryAll();

    /**
     * 添加商品分类
     * */
    public boolean insertCategory(Category category);

    /**
     * 删除商品分类
     * */
    public boolean deleteCategory(int categoryId);


   /* int deleteByPrimaryKey(Integer categoryId);

    int insert(Category record);

    int insertSelective(Category record);

    Category selectByPrimaryKey(Integer categoryId);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);*/
}