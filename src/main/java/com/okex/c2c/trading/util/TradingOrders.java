package com.okex.c2c.trading.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;
import java.util.TreeMap;

import com.okex.c2c.trading.web.model.OrderModel;
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
        if (model.getBuy() == null || model.getBuy().isEmpty()) {
            return null;
        }
        return model.getBuy().get(0).getPrice();
    }

    public static BigDecimal minSellPrice(TradingOrderModel model) {
        if (model.getSell() == null || model.getSell().isEmpty()) {
            return null;
        }
        return model.getSell().get(model.getSell().size() - 1).getPrice();
    }

    public static Map<BigDecimal, BigDecimal> sellPriceBalanceMap(TradingOrderModel model) {
        Map<BigDecimal, BigDecimal> result = new TreeMap<>((o1, o2) -> -o1.compareTo(o2));
        if (model.getSell() == null || model.getSell().isEmpty()) {
            return result;
        }
        BigDecimal total = BigDecimal.valueOf(0);
        for (OrderModel tradingOrder : model.getSell()) {
            BigDecimal balance = result.get(tradingOrder.getPrice());
            if (balance == null) {
                result.put(tradingOrder.getPrice(), tradingOrder.getAvailableAmount());
            } else {
                result.put(tradingOrder.getPrice(), balance.add(tradingOrder.getAvailableAmount()));
            }
            total = total.add(tradingOrder.getAvailableAmount());
        }
        result.put(BigDecimal.valueOf(10), total);
        return result;
    }

    public static Map<BigDecimal, Integer> sellPriceCountMap(TradingOrderModel model) {
        Map<BigDecimal, Integer> result = new TreeMap<>((o1, o2) -> -o1.compareTo(o2));
        if (model.getSell() == null || model.getSell().isEmpty()) {
            return result;
        }
        for (OrderModel tradingOrder : model.getSell()) {
            Integer count = result.get(tradingOrder.getPrice());
            if (count == null) {
                result.put(tradingOrder.getPrice(), 1);
            } else {
                result.put(tradingOrder.getPrice(), count + 1);
            }
        }
        return result;
    }

    public static Map<BigDecimal, BigDecimal> buyPriceBalanceMap(TradingOrderModel model) {
        Map<BigDecimal, BigDecimal> result = new TreeMap<>();
        if (model.getBuy() == null || model.getBuy().isEmpty()) {
            return result;
        }
        BigDecimal total = BigDecimal.valueOf(0);
        for (OrderModel tradingOrder : model.getBuy()) {
            BigDecimal balance = result.get(tradingOrder.getPrice());
            if (balance == null) {
                result.put(tradingOrder.getPrice(), tradingOrder.getQuoteMaxAmountPerOrder().divide(tradingOrder.getPrice(), RoundingMode.HALF_UP));
            } else {
                result.put(tradingOrder.getPrice(), balance.add(tradingOrder.getQuoteMaxAmountPerOrder().divide(tradingOrder.getPrice(), RoundingMode.HALF_UP)));
            }
            total = total.add(tradingOrder.getAvailableAmount());
        }
        result.put(BigDecimal.valueOf(0), total);
        return result;
    }

    public static Map<BigDecimal, Integer> buyPriceCountMap(TradingOrderModel model) {
        Map<BigDecimal, Integer> result = new TreeMap<>();
        if (model.getBuy() == null || model.getBuy().isEmpty()) {
            return result;
        }
        for (OrderModel tradingOrder : model.getBuy()) {
            Integer count = result.get(tradingOrder.getPrice());
            if (count == null) {
                result.put(tradingOrder.getPrice(), 1);
            } else {
                result.put(tradingOrder.getPrice(), count + 1);
            }
        }
        return result;
    }

}
