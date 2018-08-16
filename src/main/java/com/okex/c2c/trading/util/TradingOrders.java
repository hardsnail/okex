package com.okex.c2c.trading.util;

import java.math.BigDecimal;

import com.okex.c2c.trading.web.model.TradingOrderModel;

public class TradingOrders {

    public static BigDecimal priceDifference(TradingOrderModel model) {
        BigDecimal maxBuyPrice = maxBuyPrice(model);
        BigDecimal minSellPrice = minSellPrice(model);
        if (maxBuyPrice == null || minSellPrice == null) {
            return null;
        }
        return minSellPrice.subtract(maxBuyPrice);
    }

    public static BigDecimal maxBuyPrice(TradingOrderModel model) {
        if (model.getBuyTradingOrders() == null || model.getBuyTradingOrders().isEmpty()) {
            return null;
        }
        return model.getBuyTradingOrders().get(0).getExchangeRate();
    }

    public static BigDecimal minSellPrice(TradingOrderModel model) {
        if (model.getSellTradingOrders() == null || model.getSellTradingOrders().isEmpty()) {
            return null;
        }
        return model.getSellTradingOrders().get(model.getSellTradingOrders().size() - 1).getExchangeRate();
    }

}
