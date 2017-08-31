package com.ed.domain;

public class OrderItem {
    private  int id;
    private int count;//商品数量
    private double subtotal;//小计
    private Product product;//商品
    private Order order;

    public void setId(int id) {
        this.id = id;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setOrder(Order order) {
        this.order = order;
    }


    public int getId() {

        return id;
    }

    public int getCount() {
        return count;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public Product getProduct() {
        return product;
    }

    public Order getOrder() {
        return order;
    }
}
