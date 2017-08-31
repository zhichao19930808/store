package com.ed.service;

import com.ed.dao.OrderDao;
import com.ed.domain.Order;
import com.ed.domain.OrderItem;
import com.ed.utils.DataSourceUtils;

import java.sql.SQLException;

public class OrderService {
    public static void addOrder(Order order) {
        try {
            //开启事务
            DataSourceUtils.startTransaction();
            //向order表中添加一条数据
            OrderDao.addOrder(order);
            //向orderItem表中添加若干条数据
            for (OrderItem orderItem :order.getOrderItemList() ) {
                OrderDao.addOrderItem(orderItem);
            }
            //提交事务
        } catch (SQLException e) {
            //回滚事务
            DataSourceUtils.commitAndClose();
            e.printStackTrace();
        }
    }
}

