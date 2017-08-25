package com.ed.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 通用servlet
 */
public class BaseServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
    //获取请求方法
            String ac = req.getParameter("ac");
            if (ac != null) {
    //获取子类
                Class clazz = this.getClass();
    //获取子类方法
                Method method = clazz.getMethod(ac, HttpServletRequest.class, HttpServletResponse.class);
    //执行方法
                String s = (String) method.invoke(this, req, resp);
                if (s != null) {
                    req.getRequestDispatcher(s).forward(req, resp);
                }
            }
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
