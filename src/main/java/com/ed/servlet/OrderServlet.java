package com.ed.servlet;

import com.ed.domain.*;
import com.ed.service.OrderService;
import com.ed.utils.UUIDUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
@WebServlet(urlPatterns = "/jsp/order")
public class OrderServlet extends BaseServlet {
    public String add(HttpServletRequest request, HttpServletResponse response) {
        User user = (User) request.getSession().getAttribute("user");
        //判断用户是否登录
        if (user == null) {
            request.setAttribute("msg","请登陆后提交订单！");
            return "/jsp/msg.jsp";
        }
        //封装数据，将数据添加到数据库
        Order order = new Order();
        //设置订单Id
        order.setId(UUIDUtils.getId());
        //获取下单时间
        order.setOrderTime(new Date());
        //取出购物车
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        //获取总金额
        order.setTotal(cart.getTotal());
        //获取用户id
        order.setUser(user);
        //获取订单项数据
        for (CartItem cartItem : cart.getItems()) {
            OrderItem orderItem = new OrderItem();
            //商品数量
            orderItem.setCount(cartItem.getCount());
            //小计
            orderItem.setSubtotal(cartItem.getSubTotal());
            //商品
            orderItem.setProduct(cartItem.getProduct());
            //订单
            orderItem.setOrder(order);
            //将订单项添加到list集合中
            order.getOrderItemList().add(orderItem);
        }
        //将数据添加到数据库
        OrderService.addOrder(order);
        //将数据放到request域对象中
        request.setAttribute("order",order);
        return "/jsp/order_info.jsp";
    }
}
