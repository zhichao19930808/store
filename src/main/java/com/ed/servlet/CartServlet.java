package com.ed.servlet;

import com.ed.domain.Cart;
import com.ed.domain.CartItem;
import com.ed.domain.Product;
import com.ed.service.ProductService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/jsp/cart")
public class CartServlet extends BaseServlet {

    //想购物车添加商品
    public String addCart(HttpServletRequest request, HttpServletResponse response) {
        //获取参数
        String id = request.getParameter("id");
        int count = Integer.parseInt(request.getParameter("count"));
        //通过id获取商品信息
        Product product = ProductService.findProductById(id);
        //封装数据
        CartItem cartItem = new CartItem(product, count);
        Cart cart = getCart(request);
        cart.addCart(cartItem);
        //重定向
        try {
            response.sendRedirect(request.getContextPath()+"/jsp/cart.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    //获取购物车
    private Cart getCart(HttpServletRequest request) {
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            request.getSession().setAttribute("cart",cart);
        }
        return cart;
    }

    //删除购物车中指定的商品
    public String removeCart(HttpServletRequest request, HttpServletResponse response) {
        //获取商品的id
        String id = request.getParameter("id");
        //调用购物车中的remove方法
        getCart(request).deleteById(id);
        //重定向
        try {
            response.sendRedirect("/jsp/cart.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
