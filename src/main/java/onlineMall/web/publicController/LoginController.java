package onlineMall.web.publicController;

import onlineMall.web.dao.DateConvert;
import onlineMall.web.dao.Impl.ShopDaoImpl;
import onlineMall.web.dao.Impl.UserDaoImpl;
import onlineMall.web.pojo.Shop;
import onlineMall.web.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @ Package: onlineMall.web.publicController
 * @ Author     ：linsola
 * @ Date       ：Created in 21:24 2018/12/23
 * @ Description：
 * @ Modified By：
 * @ Version:
 */
@Controller
@ResponseBody
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserDaoImpl userDaoImpl;

    @Autowired
    private ShopDaoImpl shopDaoImpl;

    private String redirectPage = "";
    /**
     * 用户登录
     * */
    @RequestMapping(value = "/userLogin", method = RequestMethod.POST)
    public void userLogin(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();

        //获取输入的用户名和密码
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");

        User user = null;
        user = userDaoImpl.userLogin(userName,password);

        //判断用户是否登录成功
        if(user!=null){
            if (user.getPassword().equals(password)) {
                //登录成功 将user对象存到session中
                session.setAttribute("user",user);
                //重新定向到首页
                redirectPage = "/index.jsp";
                request.getRequestDispatcher(redirectPage).forward(request, response);
            }else {
                //密码错误
                request.setAttribute("loginError","密码错误");
                redirectPage = "/userLogin.jsp";
                request.getRequestDispatcher(redirectPage).forward(request, response);
            }
        }else {
            request.setAttribute("loginError","用户名不存在");
            redirectPage = "/userLogin.jsp";
            request.getRequestDispatcher(redirectPage).forward(request, response);
        }
    }

    /**
     * 用户注销
     * */
    @RequestMapping(value = "/userLoginOut",method = RequestMethod.POST)
    public void userLoginOut(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        //从session中将user删除
        session.removeAttribute("user");
        redirectPage = "/userLogin.jsp";
        request.getRequestDispatcher(redirectPage).forward(request, response);
    }

    /**
     * 用户注册
     * */
    @RequestMapping(value = "/userRegister",method = RequestMethod.POST)
    @ResponseBody
    public void userRegister(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        User user = new User();
        DateConvert dateConvert = new DateConvert();
        user.setUserId(null);
        user.setUserName(request.getParameter("userName"));
        user.setPassword(request.getParameter("password"));
        user.setName(request.getParameter("name"));
        user.setEmail(request.getParameter("email"));
        user.setPhone(request.getParameter("phone"));
        user.setBirthday(dateConvert.convert(request.getParameter("birthday")));
        user.setSex(request.getParameter("sex"));
        user.setType(request.getParameter("type"));

        userDaoImpl.userRegister(user);
        //注册成功，跳转到userLogin.jsp
        redirectPage = "/userLogin.jsp";
        request.getRequestDispatcher(redirectPage).forward(request, response);
    }

    /**
     * 管理员登录
     * */
    @RequestMapping(value = "/administratorLogin", method = RequestMethod.POST)
    public void administratorLogin(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();

        //获取输入的用户名和密码
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");

        User user = null;
        user = userDaoImpl.administratorLogin(userName,password);

        //判断用户是否登录成功
        if(user!=null){
            if (user.getPassword().equals(password)) {
                //登录成功 将user对象存到session中
                session.setAttribute("user",user);
                //重新定向到首页
                redirectPage = "/WEB-INF/views/administrator.jsp";
                request.getRequestDispatcher(redirectPage).forward(request, response);
            }else {
                //密码错误
                request.setAttribute("loginError","密码错误");
                redirectPage = "/administratorLogin.jsp";
                request.getRequestDispatcher(redirectPage).forward(request, response);
            }
        }else {
            request.setAttribute("loginError","用户名不存在");
            redirectPage = "/administratorLogin.jsp";
            request.getRequestDispatcher(redirectPage).forward(request, response);
        }
    }

    /**
     * 管理员注销
     * */
    @RequestMapping(value = "/administratorLoginOut",method = RequestMethod.POST)
    public void administratorLoginOut(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        //从session中将user删除
        session.removeAttribute("user");
        redirectPage = "/administratorLogin.jsp";
        request.getRequestDispatcher(redirectPage).forward(request, response);
    }

    /**
     * 商家登录
     * */
    @RequestMapping(value = "/shopLogin", method = RequestMethod.POST)
    public void shopLogin(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();

        //获取输入的用户名和密码
        String shopName = request.getParameter("shopName");
        String password = request.getParameter("password");

        Shop shop = null;
        shop = shopDaoImpl.shopLogin(shopName,password);

        //判断用户是否登录成功
        if(shop!=null){
            if (shop.getPassword().equals(password)) {
                //登录成功 将shop对象存到session中
                session.setAttribute("shop",shop);
                //重新定向到首页
                redirectPage = "/WEB-INF/views/shop.jsp";
                request.getRequestDispatcher(redirectPage).forward(request, response);
            }else {
                //密码错误
                request.setAttribute("loginError","密码错误");
                redirectPage = "/shopLogin.jsp";
                request.getRequestDispatcher(redirectPage).forward(request, response);
            }
        }else {
            request.setAttribute("loginError","商店名不存在");
            redirectPage = "/shopLogin.jsp";
            request.getRequestDispatcher(redirectPage).forward(request, response);
        }
    }

    /**
     * 商家注销
     * */
    @RequestMapping(value = "/shopLoginOut",method = RequestMethod.POST)
    public void shopLoginOut(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        //从session中将shop删除
        session.removeAttribute("shop");
        redirectPage = "/shopLogin.jsp";
        request.getRequestDispatcher(redirectPage).forward(request, response);
    }

    /**
     * 商家注册
     * */
    @RequestMapping(value = "/shopRegister",method = RequestMethod.POST)
    @ResponseBody
    public void shopRegister(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        Shop shop = new Shop();

        shop.setShopId(null);
        shop.setShopName(request.getParameter("shopName"));
        shop.setPassword(request.getParameter("password"));
        shop.setEmail(request.getParameter("email"));
        shop.setPhone(request.getParameter("phone"));
        shop.setOwnerName(request.getParameter("ownerName"));

        shopDaoImpl.shopRegister(shop);
        //注册成功，跳转到shopLogin.jsp
        redirectPage = "/shopLogin.jsp";
        request.getRequestDispatcher(redirectPage).forward(request, response);
    }
}
