package com.example.smm16.scancodepaydemo;

public class OrderPay {
    private long pid;
    private int payType;//支付种类0：威信、1：支付宝、2：银联 9：其他
    private OrderBean orderBean;

    public OrderPay(long pid, int payType, OrderBean orderBean) {
        this.pid = pid;
        this.payType = payType;
        this.orderBean = orderBean;
    }

    public long getPid() {
        return pid;
    }

    public void setPid(long pid) {
        this.pid = pid;
    }



    public int getPayType() {
        return payType;
    }

    public void setPayType(int payType) {
        this.payType = payType;
    }

    public OrderBean getOrderBean() {
        return orderBean;
    }

    public void setOrderBean(OrderBean orderBean) {
        this.orderBean = orderBean;
    }

    @Override
    public String toString() {
        return "OrderPay{" +
                "pid=" + pid +
                ", payType=" + payType +
                ", orderBean=" + orderBean +
                '}';
    }
}
