package onlineMall.web.customer.controller;

import onlineMall.web.dao.DateConvert;
import onlineMall.web.dao.Impl.UserDaoImpl;
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
 * @author FT丶Kuroko
 * @date 2018/12/22 14:40
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserDaoImpl userDao;
    //用户登录
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public void login(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
        HttpSession session = request.getSession();

        //获取输入的用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = null;
        user = userDao.login(username,password);

        //判断用户是否登录成功
        if(user!=null){
            if (user.getPassword().equals(password)) {
                //登录成功 将user对象存到session中
                session.setAttribute("user",user);
                //重新定向到首页
                response.sendRedirect(request.getContextPath()+"index.jsp");
            }else {
                //密码错误
                request.setAttribute("loginError","密码错误");
                response.sendRedirect(request.getContextPath()+"/login.jsp");
            }
        }else {
            request.setAttribute("loginError","用户名不存在");
            request.getRequestDispatcher("/login.jsp");
        }
    }

    //用户注销
    @RequestMapping(value = "/logout",method = RequestMethod.POST)
    @ResponseBody
    public void logout(HttpServletRequest request,HttpServletResponse response)throws IOException{
        HttpSession session = request.getSession();
        //从session中将user删除
        session.removeAttribute("user");

        response.sendRedirect(request.getContextPath()+"login.jsp");
    }

    //用户注册
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @ResponseBody
    public void register(HttpServletRequest request,HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        User user = new User();
        DateConvert dateConvert = new DateConvert();
        user.setUserName(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));
        user.setName(request.getParameter("name"));
        user.setEmail(request.getParameter("email"));
        user.setPhone(request.getParameter("phone"));
        user.setBirthday(dateConvert.convert(request.getParameter("birthday")));
        user.setSex(request.getParameter("sex"));
        user.setType(request.getParameter("type"));

        userDao.insert(user);
        response.sendRedirect(request.getContextPath()+"");//注册成功后的界面
    }
}
