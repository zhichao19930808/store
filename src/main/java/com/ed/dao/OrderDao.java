package com.ed.dao;

import com.ed.domain.Order;
import com.ed.domain.OrderItem;
import com.ed.utils.C3p0Util;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.SQLException;

public class OrderDao {
    public static void addOrder(Order order) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(C3p0Util.getDataSource());
        String sql = "INSERT INTO db_store.orders(id,ordertime, total, address, name, phone, uId) VALUES (?,?,?,?,?,?,?)";
        queryRunner.update(sql,order.getId(), order.getOrderTime(), order.getTotal(), order.getAddress(), order.getName(), order.getPhone(), order.getUser().getId());
    }

    public static void addOrderItem(OrderItem orderItem) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(C3p0Util.getDataSource());
        String sql = "INSERT INTO db_store.orderItem(count, subtotal, pId, oId) VALUES (?,?,?,?)";
        queryRunner.update(sql, orderItem.getCount(), orderItem.getSubtotal(), orderItem.getProduct().getId(), orderItem.getOrder().getId());
    }
}
