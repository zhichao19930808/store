package com.ed.service;

import com.ed.dao.ProductDao;
import com.ed.domain.Kind;
import com.ed.domain.Product;

import java.util.List;

public class ProductService {
    public static List<Product> findProduct(String product) {
        return ProductDao.findProduct(product);
    }
    public static Product findProductById(String id) {
        return ProductDao.findProductById(id);
    }

    public static List<Product> findAll() {
        return ProductDao.findProduct("findAll");
    }
}
