package onlineMall.web.dao;

import onlineMall.web.pojo.Category;

import java.util.ArrayList;

public interface CategoryDao {

    ArrayList<Category> queryAll();

    int deleteByPrimaryKey(Integer categoryId);

    int insert(Category record);

    int insertSelective(Category record);

    Category selectByPrimaryKey(Integer categoryId);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);
}