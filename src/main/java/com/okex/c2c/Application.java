package com.okex.c2c;

import java.math.BigDecimal;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.okex.c2c.trading.component.TradingOrderContext;
import com.okex.c2c.trading.util.TradingOrders;
import com.okex.c2c.trading.web.model.TradingOrderModel;

@SpringBootApplication
@EnableAutoConfiguration
public class Application {
    public static void main(String[] args) {
        // SpringApplication.run(Application.class, args);

        TradingOrderContext tradingOrderContext = new TradingOrderContext();
        TradingOrderModel tradingOrderModel = tradingOrderContext.currentTrading("btc");

        BigDecimal diffrence = TradingOrders.priceDifference(tradingOrderModel);
        BigDecimal buyPrice = TradingOrders.maxBuyPrice(tradingOrderModel);
        BigDecimal sellPrice = TradingOrders.minSellPrice(tradingOrderModel);

        System.out.println(String.format("buyPrice %s, sellPrice %s, diffrence %s", buyPrice, sellPrice, diffrence));
    }
}
