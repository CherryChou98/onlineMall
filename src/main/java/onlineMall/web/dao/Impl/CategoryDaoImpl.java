package onlineMall.web.dao.Impl;

import onlineMall.web.dao.CategoryDao;
import onlineMall.web.dao.Dbutil;
import onlineMall.web.pojo.Category;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * @ Package: onlineMall.web.dao.Impl
 * @ Author     ：linsola
 * @ Date       ：Created in 19:43 2018/12/20
 * @ Description：
 * @ Modified By：
 * @ Version:
 */
@Repository
public class CategoryDaoImpl implements CategoryDao {

    private Dbutil dbutil;

    public CategoryDaoImpl(Dbutil dbutil) {
        this.dbutil = Dbutil.getInstance();
        try {
            dbutil.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Category> queryAll() {
        ArrayList<Category> list = new ArrayList<>();

        try {
            String sql = "SELECT CATEGORY_ID, NAME FROM category";
            ResultSet rs = dbutil.executeQuery(sql);
            while (rs.next()){
                Category category = new Category();
                category.setCategoryId(rs.getInt("CATEGORY_ID"));
                category.setName(rs.getString("NAME"));
                list.add(category);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int deleteByPrimaryKey(Integer categoryId) {
        return 0;
    }

    @Override
    public int insert(Category record) {
        return 0;
    }

    @Override
    public int insertSelective(Category record) {
        return 0;
    }

    @Override
    public Category selectByPrimaryKey(Integer categoryId) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Category record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Category record) {
        return 0;
    }
}
