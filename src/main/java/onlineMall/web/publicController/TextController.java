package onlineMall.web.publicController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @ Package: onlineMall.web.shop.controller
 * @ Author     ：linsola
 * @ Date       ：Created in 17:18 2018/12/22
 * @ Description：
 * @ Modified By：
 * @ Version:
 */
@Controller
@RequestMapping("/text")
public class TextController {
    @RequestMapping(value = "/shop", method = RequestMethod.GET)
    public String textShop(){
        return "shop";
    }

    @RequestMapping(value = "/administrator", method = RequestMethod.GET)
    public String textAdmin(){
        return "administrator";
    }
}
