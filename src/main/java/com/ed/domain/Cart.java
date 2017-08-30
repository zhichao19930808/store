package com.ed.domain;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Cart {
    //存放购物车项的集合
    private Map<String, CartItem> map = new HashMap<String, CartItem>();
    //总金额
    private double total = 0.0;

    //将CartItem存入到map集合中
    public void addCart(CartItem cartItem) {
        //获取商品id
        String id = cartItem.getProduct().getId();
        //判断当前购物车有无此商品
        if (map.containsKey(id)) {//若当前购物车有此商品
            CartItem cartItem1 = map.get(id);
            cartItem1.setCount(cartItem1.getCount() + cartItem.getCount());
        } else {
            map.put(id, cartItem);
        }
        //总金额
        total += cartItem.getSubTotal();
    }

    //根据id删除商品
    public void deleteById(String id) {
        CartItem cartItem = map.remove(id);
        total -= cartItem.getSubTotal();
    }

    //清空购物车
    public void deleteAll() {
        map.clear();
        total = 0.0;
    }

    //获取所有的购物车项
    public Collection<CartItem> getItems(){
        return map.values();
    }
    public void setMap(Map<String, CartItem> map) {
        this.map = map;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Map<String, CartItem> getMap() {

        return map;
    }

    public double getTotal() {
        return total;
    }
}
