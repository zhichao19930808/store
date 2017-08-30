package com.ed.service;

import com.ed.dao.KindDao;
import com.ed.dao.ProductDao;
import com.ed.domain.Kind;
import com.ed.domain.Page;
import com.ed.domain.Product;

import java.util.List;

public class KindService {
    public static List<Kind> getKind() {
        return KindDao.getKind();
    }
    public static Kind findKindById(int id) {
        return KindDao.findKindById(id);
    }
    public static Page findProductByKind(int currPage, int pageSize, int kid) {
        List<Product> productList = ProductDao.findProductByKind(currPage, pageSize, kid);
        //总数
        int totalCount = ProductDao.getCountByKind(kid);
        int totalPage = (int) Math.ceil(totalCount * 1.0 / pageSize);
        Page page = new Page(currPage,pageSize,totalPage,totalCount,productList);
        return page;
    }
}
