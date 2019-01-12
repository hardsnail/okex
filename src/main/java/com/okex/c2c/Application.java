package com.okex.c2c;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.okex.c2c.trading.component.TradingOrderContext;
import com.okex.c2c.trading.util.TradingOrders;
import com.okex.c2c.trading.web.model.OrderModel;
import com.okex.c2c.trading.web.model.TradingOrderModel;

@SpringBootApplication
@EnableAutoConfiguration
public class Application {
    public static void main(String[] args) {
//         SpringApplication.run(Application.class, args);

        printBasicInfo();

//        RingMainThread thread = new RingMainThread();
//        thread.start();
    }

    private static void printBasicInfo() {
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        TradingOrderContext tradingOrderContext = new TradingOrderContext();
        TradingOrderModel tradingOrderModel = tradingOrderContext.currentTrading("usdt");
        
        List<OrderModel> orderModelList = tradingOrderModel.getSell();
        System.out.println("昵称\t日期限制\t\t单数限制\t挂单时间");
        for(OrderModel orderModel : orderModelList){
        	String nickName = orderModel.getCreator().getNickName();
        	nickName = nickName.length() > 6 ? nickName.substring(0, 6) : nickName; 
        	System.out.print(nickName + "\t");
//        	System.out.print(orderModel.getAvailableAmount().intValue() + "\t");
        	if(orderModel.getMaxUserCreatedDate() > 0){
        		System.out.print(sdf.format(new Date(orderModel.getMaxUserCreatedDate())));
        	}else{
        		System.out.print("2019-01-06");
        	}
        	System.out.print("\t");
        	System.out.print(orderModel.getMinCompletedOrderQuantity());
        	System.out.print("\t");
    		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(orderModel.getCreatedDate())));

        }

        BigDecimal diffrence = TradingOrders.priceDifference(tradingOrderModel);
        BigDecimal buyPrice = TradingOrders.maxBuyPrice(tradingOrderModel);
        BigDecimal sellPrice = TradingOrders.minSellPrice(tradingOrderModel);

        System.out.println(String.format("buyPrice %s, sellPrice %s, diffrence %s", buyPrice, sellPrice, diffrence));

        Map<BigDecimal, BigDecimal> sellPriceBalanceMap = TradingOrders.sellPriceBalanceMap(tradingOrderModel);
        try {
            System.out.println("sellPriceBalanceMap :" + new ObjectMapper().writeValueAsString(sellPriceBalanceMap));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        Map<BigDecimal, BigDecimal> buyPriceBalanceMap = TradingOrders.buyPriceBalanceMap(tradingOrderModel);
        try {
            System.out.println("buyPriceBalanceMap : " + new ObjectMapper().writeValueAsString(buyPriceBalanceMap));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        Map<BigDecimal, Integer> sellPriceCountMap = TradingOrders.sellPriceCountMap(tradingOrderModel);
        try {
            System.out.println("sellPriceCountMap : " + new ObjectMapper().writeValueAsString(sellPriceCountMap));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        Map<BigDecimal, Integer> buyPriceCountMap = TradingOrders.buyPriceCountMap(tradingOrderModel);
        try {
            System.out.println("buyPriceCountMap : " + new ObjectMapper().writeValueAsString(buyPriceCountMap));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
