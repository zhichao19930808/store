package com.ed.domain;

public class Product {
    private String id;
    private String name;
    private String market_price;//商城价
    private String shop_price;//市场价
    private String pimage;
    private String pdate;
    private String is_hot;//是否热门  1：热门   0非热门
    private String pdesc;
    private int pflag;//是否下架  0：未下架  1：下架
    private int cid;//主外键   商品的类别id   表category中的id字段

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMarket_price(String market_price) {
        this.market_price = market_price;
    }

    public void setShop_price(String shop_price) {
        this.shop_price = shop_price;
    }

    public void setPimage(String pimage) {
        this.pimage = pimage;
    }

    public void setPdate(String pdate) {
        this.pdate = pdate;
    }

    public void setIs_hot(String is_hot) {
        this.is_hot = is_hot;
    }

    public void setPdesc(String pdesc) {
        this.pdesc = pdesc;
    }

    public void setPflag(int pflag) {
        this.pflag = pflag;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getId() {

        return id;
    }

    public String getName() {
        return name;
    }

    public String getMarket_price() {
        return market_price;
    }

    public String getShop_price() {
        return shop_price;
    }

    public String getPimage() {
        return pimage;
    }

    public String getPdate() {
        return pdate;
    }

    public String getIs_hot() {
        return is_hot;
    }

    public String getPdesc() {
        return pdesc;
    }

    public int getPflag() {
        return pflag;
    }

    public int getCid() {
        return cid;
    }
}
