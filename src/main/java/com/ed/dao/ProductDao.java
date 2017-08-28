package com.ed.dao;

import com.ed.domain.Product;
import com.ed.utils.C3p0Util;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class ProductDao {
    public static List<Product> findProduct(String product) {
        QueryRunner queryRunner = new QueryRunner(C3p0Util.getDataSource());
        List<Product> productList = null;
        String fingNew = "SELECT * FROM db_store.product ORDER BY pdate DESC LIMIT 9";
        String fingHot = "SELECT * FROM db_store.product WHERE is_hot = 1 ORDER BY pdate DESC LIMIT 9";
        try {
            if (product.equals("findNew")) {
                productList = queryRunner.query(fingNew, new BeanListHandler<Product>(Product.class));
            }
            if (product.equals("findHot")) {
                productList = queryRunner.query(fingHot, new BeanListHandler<Product>(Product.class));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }

    public static Product findProductById(String id) {
        QueryRunner queryRunner = new QueryRunner(C3p0Util.getDataSource());
        String sql = "SELECT * FROM db_store.product WHERE id=?";
        Product product = null;
        try {
            product = queryRunner.query(sql, new BeanHandler<Product>(Product.class), id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }
}
