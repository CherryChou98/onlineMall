package onlineMall.web.publicController;

import onlineMall.web.dao.Impl.ItemDaoImpl;
import onlineMall.web.pojo.Item;
import onlineMall.web.pojo.ItemWithCategory;
import onlineMall.web.pojo.ItemWithImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

/**
 * @ Package: onlineMall.web.publicController
 * @ Author     ：linsola
 * @ Date       ：Created in 15:24 2018/12/23
 * @ Description：
 * @ Modified By：
 * @ Version:
 */
@Controller
@ResponseBody
public class PublicItemController {
    @Autowired
    private ItemDaoImpl itemDaoImpl;

    /**
     * 查看商品信息，不包含图片，测试成功，各模块复用
     * */
    @RequestMapping(value = "/item/viewItem",  method = RequestMethod.GET)
    public ArrayList<ItemWithCategory> viewItem(@RequestParam("shopId") int shopId){
        ArrayList<ItemWithCategory> itemWithCategories = itemDaoImpl.viewItem(shopId);
        return itemWithCategories;
    }

    /**
     * 商家查看商品信息，传入shopId，包含图片，测试成功，各模块复用
     * */
    @RequestMapping(value = "/item/viewItemMessage",  method = RequestMethod.GET)
    public ArrayList<ItemWithImage> viewItemMessage(@RequestParam("shopId") int shopId){
        ArrayList<ItemWithImage> itemWithImages = itemDaoImpl.viewItemMessage(shopId);
        return itemWithImages;
    }

    /**
     * 根据类别查看商品信息，传入categoryId，包含图片，测试成功，各模块复用
     * */
    @RequestMapping(value = "/item/viewItemMessageByCategory",  method = RequestMethod.GET)
    public ArrayList<ItemWithImage> viewItemMessageByCategory(@RequestParam("categoryId") int categoryId){
        ArrayList<ItemWithImage> itemWithImages = itemDaoImpl.viewItemMessageByCategory(categoryId);
        return itemWithImages;
    }

    /**
     * 搜索商品信息，测试成功，各模块复用
     * */
    @RequestMapping(value = "/item/queryItem",  method = RequestMethod.GET)
    public ArrayList<Item> queryItem(@RequestParam("name") String name){
        String name1 = "%"+name+"%";
        ArrayList<Item> items = itemDaoImpl.queryItem(name1);
        return items;
    }

    /**
     * 删除商品信息，测试成功，商家，管理员模块复用
     * */
    @RequestMapping(value = "/item/deleteItemMessage",  method = RequestMethod.GET)
    public boolean deleteItemMessage(@RequestParam("itemId") int itemId){
        boolean flag = itemDaoImpl.deleteItemMessage(itemId);
        return flag;
    }
}
