package com.ed.domain;

import java.util.List;

public class Page<T> {
    private int currPage;//当前页
    private int pageSize;//每页的大小
    private int totalPage;//多少页
    private int totalCount;//共多少个
    private List<T> productList;

    public Page(int currPage, int pageSize, int totalPage, int totalCount, List<T> productList) {
        this.currPage = currPage;
        this.pageSize = pageSize;
        this.totalPage = totalPage;
        this.totalCount = totalCount;
        this.productList = productList;
    }

    public void setCurrPage(int currPage) {

        this.currPage = currPage;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public void setProductList(List<T> productList) {
        this.productList = productList;
    }

    public int getCurrPage() {

        return currPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public List<T> getProductList() {
        return productList;
    }
}
