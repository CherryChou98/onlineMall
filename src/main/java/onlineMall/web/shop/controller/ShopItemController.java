package onlineMall.web.shop.controller;

import onlineMall.web.dao.Impl.ItemDaoImpl;
import onlineMall.web.pojo.Item;
import onlineMall.web.pojo.ItemWithCategory;
import onlineMall.web.pojo.ItemWithImage;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @ Package: onlineMall.web.shop.controller
 * @ Author     ：linsola
 * @ Date       ：Created in 17:12 2018/12/21
 * @ Description：
 * @ Modified By：
 * @ Version:
 */
@Controller
@ResponseBody
@RequestMapping("/shop/item")
public class ShopItemController {
    @Autowired
    private ItemDaoImpl itemDaoImpl;

    /**
     * 上传图片，待测试，插入到image表，仅支持单张上传
     * */
    @RequestMapping(value = "/insertItemImage", method = RequestMethod.POST,produces="application/json;charset=utf-8")
    public boolean insertItemImage(@RequestParam(value = "files", required = false) MultipartFile file, int itemId, String imageDescription){
        try {
            FileUtils.writeByteArrayToFile(new File("F:/Java Project/workspace/onlineMall/src/main/webapp/static/image" + file.getOriginalFilename()), file.getBytes());
            String path1 = file.getOriginalFilename();
            String imageUrl = "<img src=\"../image/"+path1+"\">";
            //insertImage可以区分itemId为零时/itemId非零时
            if(itemDaoImpl.insertImage(imageUrl,itemId,imageDescription)){
                return true;
            }
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 上传商品信息，待测试，插入到item表
     * */
    @RequestMapping(value = "/insertItem", method = RequestMethod.POST)
    public boolean insertItem(@ModelAttribute Item item){
        boolean flag = itemDaoImpl.insertItem(item);
        return flag;
    }

}
