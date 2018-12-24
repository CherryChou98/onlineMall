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
    public boolean insertCategory(Category category) {
        int categoryId = category.getCategoryId();
        String name = category.getName();
        boolean flag = false;
        String sql = "INSERT INTO category(CATEGORY_ID,NAME) VALUES(?,?)";
        try {
            int r = dbutil.executeUpdate(sql,categoryId,name);
            if(r!=0){
                flag = true;
            }else {
                flag = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean deleteCategory(int categoryId) {
        boolean flag = false;
        String sql = "DELETE FROM category WHERE CATEGORY_ID=?";
        try {
            int r = dbutil.executeUpdate(sql,categoryId);
            if(r!=0){
                flag = true;
            }else {
                flag = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }
}
