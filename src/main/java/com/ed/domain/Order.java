package com.ed.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private String id;
    private Date orderTime;//下单时间
    private double total;//总金额
    private int state;//订单状态 0/1
    private String address;//收货人地址
    private String name;//收货人姓名
    private String phone;//收货人电话
    private User user;//用户

    public void setId(String id) {
        this.id = id;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setState(int state) {
        this.state = state;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setOrderItemList(List<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }

    public String getId() {
        return id;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public double getTotal() {
        return total;
    }

    public int getState() {
        return state;
    }

    public String getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public User getUser() {
        return user;
    }

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    private List<OrderItem> orderItemList = new ArrayList<>();
}
