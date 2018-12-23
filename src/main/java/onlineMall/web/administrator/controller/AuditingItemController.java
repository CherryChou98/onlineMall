package onlineMall.web.administrator.controller;

import onlineMall.web.dao.Impl.ItemDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ Package: onlineMall.web.administrator.controller
 * @ Author     ：linsola
 * @ Date       ：Created in 14:10 2018/12/23
 * @ Description：
 * @ Modified By：
 * @ Version:
 */
@Controller
@RequestMapping("/administrator/item")
@ResponseBody
public class AuditingItemController {
    @Autowired
    private ItemDaoImpl itemDaoImpl;

    /**
     * 管理员审核商品是否通过，测试成功
     * */
    @RequestMapping(value = "/auditingItem", method = RequestMethod.GET)
    public boolean auditingItem(@RequestParam("itemId") int itemId){
        boolean flag = itemDaoImpl.auditingItem(itemId);
        return flag;
    }
}
