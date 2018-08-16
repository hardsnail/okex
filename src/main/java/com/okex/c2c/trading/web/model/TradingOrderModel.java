package com.okex.c2c.trading.web.model;

import java.io.Serializable;
import java.util.List;

import com.okex.c2c.trading.entity.TradingOrder;

public class TradingOrderModel implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<TradingOrder> bestTradingOrders;

    private List<TradingOrder> sellTradingOrders;

    private List<TradingOrder> buyTradingOrders;

    public List<TradingOrder> getSellTradingOrders() {
        return sellTradingOrders;
    }

    public void setSellTradingOrders(List<TradingOrder> sellTradingOrders) {
        this.sellTradingOrders = sellTradingOrders;
    }

    public List<TradingOrder> getBuyTradingOrders() {
        return buyTradingOrders;
    }

    public void setBuyTradingOrders(List<TradingOrder> buyTradingOrders) {
        this.buyTradingOrders = buyTradingOrders;
    }

    public List<TradingOrder> getBestTradingOrders() {
        return bestTradingOrders;
    }

    public void setBestTradingOrders(List<TradingOrder> bestTradingOrders) {
        this.bestTradingOrders = bestTradingOrders;
    }

}
