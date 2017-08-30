package com.ed.domain;

public class CartItem {
    private Product product;//商品bean对象
    private int count; //购买商品的数量
    private double subTotal = 0.0;//小计

    public CartItem(Product product, int count) {
        this.product = product;
        this.count = count;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public Product getProduct() {

        return product;
    }

    public int getCount() {
        return count;
    }

    public double getSubTotal() {
        return Double.valueOf(product.getShop_price())*count;
    }
}
