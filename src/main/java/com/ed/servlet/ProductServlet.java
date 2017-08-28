package com.ed.servlet;

import com.ed.domain.Kind;
import com.ed.domain.Product;
import com.ed.service.KindService;
import com.ed.service.ProductService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/jsp/product")
public class ProductServlet extends BaseServlet {

    public String findProductById(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        Product product = ProductService.findProductById(id);
        Kind kind = KindService.findKindById(product.getCid());
        request.setAttribute("product",product);
        request.setAttribute("kind",kind);
        return "product_info.jsp";
    }
}
