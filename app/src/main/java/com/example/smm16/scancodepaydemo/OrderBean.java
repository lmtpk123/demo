package com.example.smm16.scancodepaydemo;

import android.util.Log;

public class OrderBean {
    private long id;//订单号
    private long dealId;//交易号
    private String orderName;
    private String orderTime;//订单时间
    private float price;//订单价格

    public OrderBean(long id, long dealId, String orderName, float price) {
        this.id = id;
        this.dealId = dealId;
        this.orderName = orderName;

        if (price > 0) {
            this.price = price;
        } else {
            Log.e("支付商品", "支付的金额必须大于0");
        }
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getDealId() {
        return dealId;
    }

    public void setDealId(long dealId) {
        this.dealId = dealId;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    @Override
    public String toString() {
        return "OrderBean{" +
                "id=" + id +
                ", dealId=" + dealId +
                ", orderName='" + orderName + '\'' +
                ", orderTime='" + orderTime + '\'' +
                ", price=" + price +
                '}';
    }
}
