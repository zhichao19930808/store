package com.ed.servlet;

import com.ed.domain.Product;
import com.ed.service.ProductService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet(urlPatterns = "/admin/adminProduct")
public class AdminProductServlet extends BaseServlet{

    public String findAll(HttpServletRequest request, HttpServletResponse response) {
        //调用service 查询所有商品
        List<Product> productList = ProductService.findAll();
        //将商品保存到request中
        request.setAttribute("productList",productList);
        return "/admin/product/list.jsp";
    }

}
