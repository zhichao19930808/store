package com.ed.servlet;

import com.ed.domain.Kind;
import com.ed.service.KindService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet(urlPatterns = "/jsp/index")
public class IndexServlet extends BaseServlet {
    public String index(HttpServletRequest req, HttpServletResponse resp) {

//        System.out.println("查询分类信息");
//        List<Kind> kindList = KindService.getKind();
//            //将jsonString放到域对象中
//        resp.setContentType("text/html;charset = utf-8");
//        req.setAttribute("kind",kindList);

        //去数据库查询最新商品和热门商品

        //跳转
        return "/jsp/index.jsp";
    }
}
