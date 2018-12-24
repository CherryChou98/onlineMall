package onlineMall.web.customer.controller;

import onlineMall.web.dao.Impl.OrderDaoImpl;
import onlineMall.web.pojo.InsertOrder;
import onlineMall.web.pojo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * @ Package: onlineMall.web.customer.controller
 * @ Author     ：linsola
 * @ Date       ：Created in 16:34 2018/12/24
 * @ Description：
 * @ Modified By：
 * @ Version:
 */
@Controller
@ResponseBody
@RequestMapping("/customer/order")
public class OrderController {
    @Autowired
    private OrderDaoImpl orderDaoImpl;

    /**
     * 用户对购物车进行下单，待测试
     * */
    @RequestMapping(value = "/addOrder", method = RequestMethod.POST)
    public boolean addOrder(@ModelAttribute InsertOrder insertOrder){
        boolean flag = orderDaoImpl.addOrder(insertOrder);
        return flag;
    }

    /**
     * 用户查看订单信息，传入userId，测试成功
     * */
    @RequestMapping(value = "/viewOrder", method = RequestMethod.GET)
    public ArrayList<Order> customerViewOrder(@RequestParam("userId") int userId){
        ArrayList<Order> orders = orderDaoImpl.customerViewOrder(userId);
        return orders;
    }
}
