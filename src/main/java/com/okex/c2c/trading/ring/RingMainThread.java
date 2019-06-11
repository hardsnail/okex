package com.okex.c2c.trading.ring;

import java.math.BigDecimal;

import com.okex.c2c.trading.component.TradingOrderContext;
import com.okex.c2c.trading.util.Rings;
import com.okex.c2c.trading.util.TradingOrders;
import com.okex.c2c.trading.web.model.TradingOrderModel;

public class RingMainThread extends Thread {

    @Override
    public void run() {
        while (true) {
            try {
                

                TradingOrderContext tradingOrderContext = new TradingOrderContext();
                TradingOrderModel tradingOrderModel = tradingOrderContext.currentTrading("usdt");

                BigDecimal diffrence = TradingOrders.priceDifference(tradingOrderModel);
                BigDecimal buyPrice = TradingOrders.maxBuyPrice(tradingOrderModel);
                BigDecimal sellPrice = TradingOrders.minSellPrice(tradingOrderModel);
                if (diffrence.compareTo(BigDecimal.valueOf(0.05)) > 0) {
                    Rings.ring();
                }

                if (sellPrice.compareTo(BigDecimal.valueOf(6.82)) > 0) {
                    Rings.ring();
                }

                if (buyPrice.compareTo(BigDecimal.valueOf(6.75)) < 0) {
                    Rings.ring();
                }
                Thread.sleep(60000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
