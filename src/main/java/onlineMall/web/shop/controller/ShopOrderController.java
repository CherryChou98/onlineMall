package onlineMall.web.shop.controller;

import onlineMall.web.dao.Impl.OrderDaoImpl;
import onlineMall.web.pojo.Order;
import onlineMall.web.pojo.ViewOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

/**
 * @ Package: onlineMall.web.shop.controller
 * @ Author     ：linsola
 * @ Date       ：Created in 22:49 2018/12/21
 * @ Description：
 * @ Modified By：
 * @ Version:
 */
@Controller
@ResponseBody
@RequestMapping("/shop/order")
public class ShopOrderController {
    @Autowired
    private OrderDaoImpl orderDaoImpl;

    /**
     * 查看订单信息，测试成功
     * */
    @RequestMapping(value = "/viewOrder",  method = RequestMethod.GET)
    public ArrayList<ViewOrder> shopViewOrder(@RequestParam("shopId")int shopId){
        ArrayList<ViewOrder> viewOrders = orderDaoImpl.shopViewOrder(shopId);
        return viewOrders;
    }

    /**
     * 商家对订单进行发货，STATUS字段由1（已付款未发货）变2（已发货未收货），测试成功
     * */
    @RequestMapping(value = "/deliverItem",  method = RequestMethod.GET)
    public boolean deliverItem(@RequestParam("orderId")int orderId){
        boolean flag = orderDaoImpl.deliverItem(orderId);
        return flag;
    }

    /**
     * 商家搜索订单，传入订单id
     * */
    @RequestMapping(value = "/shopQueryOrder",  method = RequestMethod.GET)
    public ViewOrder shopQueryOrder(@RequestParam("orderId") int orderId){
        ViewOrder viewOrder = orderDaoImpl.shopQueryOrder(orderId);
        return viewOrder;
    }
}
