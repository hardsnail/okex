package com.okex.c2c.trading.web.model;

import java.util.List;

import com.okex.c2c.trading.entity.TradingOrder;

public class TradingOrderModel {

    private List<TradingOrder> sellOrders;

    private List<TradingOrder> buyOrders;

    public List<TradingOrder> getSellOrders() {
        return sellOrders;
    }

    public void setSellOrders(List<TradingOrder> sellOrders) {
        this.sellOrders = sellOrders;
    }

    public List<TradingOrder> getBuyOrders() {
        return buyOrders;
    }

    public void setBuyOrders(List<TradingOrder> buyOrders) {
        this.buyOrders = buyOrders;
    }

}
