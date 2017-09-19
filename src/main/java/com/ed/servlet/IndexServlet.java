package com.ed.servlet;

import com.ed.domain.Product;
import com.ed.service.ProductService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet(urlPatterns = "/jsp/index")
public class IndexServlet extends BaseServlet {
    public String index(HttpServletRequest req, HttpServletResponse resp) {
        //去数据库查询最新商品和热门商品
        List<Product>newProduct = ProductService.findProduct("findNew");
        List<Product>hotProduct = ProductService.findProduct("findHot");
        req.setAttribute("newProduct",newProduct);
        req.setAttribute("hotProduct",hotProduct);
        //跳转
        return "/jsp/index.jsp";
    }
}
