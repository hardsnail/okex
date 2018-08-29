package com.okex.c2c.trading.web.model;

import java.io.Serializable;
import java.util.List;

public class TradingOrderModel implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<OrderModel> sell;

    private List<OrderModel> buy;

    public List<OrderModel> getSell() {
        return sell;
    }

    public void setSell(List<OrderModel> sell) {
        this.sell = sell;
    }

    public List<OrderModel> getBuy() {
        return buy;
    }

    public void setBuy(List<OrderModel> buy) {
        this.buy = buy;
    }

}
