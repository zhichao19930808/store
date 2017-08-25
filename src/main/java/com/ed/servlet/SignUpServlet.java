package com.ed.servlet;

import com.ed.dao.UserDao;
import com.ed.domain.User;
import com.ed.service.SignUpService;
import com.ed.utils.MD5Utils;
import com.ed.utils.UUIDUtils;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
@WebServlet(urlPatterns = "/jsp/user")
public class SignUpServlet extends BaseServlet {

    public String SignUpUI(HttpServletRequest request, HttpServletResponse response) {
        return "/jsp/register.jsp";
    }
    public String SignUp(HttpServletRequest request, HttpServletResponse response) {
        //获取表单数据
        User user = new User();
//            //生日
//            ConvertUtils.register(new MyConventer(), Date.class);
        try {
            BeanUtils.populate(user,request.getParameterMap());
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
//            设置id
//            user.setUid(UUIDUtils.getId());
        //设置激活码
        user.setCode(UUIDUtils.getCode());
        //密码加密
        user.setPassword(MD5Utils.md5(user.getPassword()));
        //业务逻辑
        SignUpService.SignUp(user);
        request.setAttribute("msg","注册成功，请到邮箱激活账号");
        return "msg.jsp";
    }

    public String SignInUI(HttpServletRequest request, HttpServletResponse response) {
        return "login.jsp";
    }
    public String SignIn(HttpServletRequest request, HttpServletResponse response) {
        //获取表单数据
        User user = new User();
        try {
            BeanUtils.populate(user,request.getParameterMap());
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        //密码加密
        user.setPassword(MD5Utils.md5(user.getPassword()));

        User user1 = UserDao.select(user, "SignIn");
        if (user1 != null) {
            if (user1.getState() == 1) {
                request.getSession().setAttribute("user", user1);
                return "/jsp/index.jsp";
            } else {
                request.setAttribute("message","账号未激活，请到邮箱中激活");
                return "/jsp/login.jsp";                }
        } else {
            request.setAttribute("message","账号或密码错误");
            return "/jsp/login.jsp";
        }
    }

    public String logout(HttpServletRequest request, HttpServletResponse response) {
    request.getSession().invalidate();
        try {
            response.sendRedirect("/jsp/index.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
