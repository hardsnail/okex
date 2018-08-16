package com.okex.c2c.trading.util;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import com.okex.c2c.trading.entity.TradingOrder;
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

    public static Map<BigDecimal, BigDecimal> sellPriceBalanceMap(TradingOrderModel model) {
        Map<BigDecimal, BigDecimal> result = new HashMap<>();
        if (model.getSellTradingOrders() == null || model.getSellTradingOrders().isEmpty()) {
            return result;
        }
        for (TradingOrder tradingOrder : model.getSellTradingOrders()) {
            BigDecimal balance = result.get(tradingOrder.getExchangeRate());
            if (balance == null) {
                result.put(tradingOrder.getExchangeRate(), tradingOrder.getAvailableAmount());
            } else {
                result.put(tradingOrder.getExchangeRate(), balance.add(tradingOrder.getAvailableAmount()));
            }
        }
        return result;
    }

    public static Map<BigDecimal, Integer> sellPriceCountMap(TradingOrderModel model) {
        Map<BigDecimal, Integer> result = new HashMap<>();
        if (model.getSellTradingOrders() == null || model.getSellTradingOrders().isEmpty()) {
            return result;
        }
        for (TradingOrder tradingOrder : model.getSellTradingOrders()) {
            Integer count = result.get(tradingOrder.getExchangeRate());
            if (count == null) {
                result.put(tradingOrder.getExchangeRate(), 1);
            } else {
                result.put(tradingOrder.getExchangeRate(), count + 1);
            }
        }
        return result;
    }

}
