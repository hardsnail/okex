package com.okex.c2c;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.okex.c2c.spot.TickterSpotCache;
import com.okex.c2c.trading.component.TradingOrderContext;
import com.okex.c2c.trading.constant.TradingOrderConstant;
import com.okex.c2c.trading.util.TradingOrders;
import com.okex.c2c.trading.web.model.OrderModel;
import com.okex.c2c.trading.web.model.TradingOrderModel;

@SpringBootApplication
@EnableAutoConfiguration
public class Application {
    public static void main(String[] args) {
         SpringApplication.run(Application.class, args);

		while (true) {
			try {
				Thread.sleep(3000l);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			printBasicInfo();
		}

//        RingMainThread thread = new RingMainThread();
//        thread.start();
    }

    private static void printBasicInfo() {
		String currency = TradingOrderConstant.CURRENCY_BTC;
    	BigDecimal last = BigDecimal.valueOf(1);
    	
    	if(TickterSpotCache.tickterSpotMap.get(currency) != null){
    		last = TickterSpotCache.tickterSpotMap.get(currency).getLast();
    		Long timestamp = TickterSpotCache.tickterSpotMap.get(currency).getTimestamp();
    		System.out.println(new Date(timestamp));
    	}
    	
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        TradingOrderContext tradingOrderContext = new TradingOrderContext();
        TradingOrderModel tradingOrderModel = tradingOrderContext.currentTrading(currency);
        
        List<OrderModel> orderModelList = tradingOrderModel.getSell();
        System.out.println("昵称\t日期限制\t\t折合usdt\tusdt数量\t单数限制\t挂单时间");
        for(int i=orderModelList.size() -20; i<orderModelList.size(); i++){
        	OrderModel orderModel = orderModelList.get(i);
        	String nickName = orderModel.getCreator().getNickName();
        	nickName = nickName.length() > 6 ? nickName.substring(0, 6) : nickName; 
        	System.out.print(nickName + "\t");
//        	System.out.print(orderModel.getAvailableAmount().intValue() + "\t");
        	if(orderModel.getMaxUserCreatedDate() > 0){
        		System.out.print(sdf.format(new Date(orderModel.getMaxUserCreatedDate())));
        	}else{
        		System.out.print(sdf.format(new Date()));
        	}
        	
        	
        	System.out.print("\t");
        	System.out.print(orderModel.getPrice().divide(last,3, RoundingMode.HALF_DOWN));
        	System.out.print("\t");
        	System.out.print(orderModel.getAvailableAmount().multiply(last).intValue());
        	System.out.print("\t");
        	System.out.print(orderModel.getMinCompletedOrderQuantity());
        	System.out.print("\t");
    		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(orderModel.getCreatedDate())));

        }
        
        System.out.println("-----------------------------------------------------------");
        List<OrderModel> buyOrderModelList = tradingOrderModel.getBuy();
        System.out.println("昵称\t日期限制\t\t折合usdt\tusdt数量\t单数限制\t挂单时间");
        for(int i=0; i<10; i++){
        	OrderModel orderModel = buyOrderModelList.get(i);
        	String nickName = orderModel.getCreator().getNickName();
        	nickName = nickName.length() > 6 ? nickName.substring(0, 6) : nickName; 
        	System.out.print(nickName + "\t");
//        	System.out.print(orderModel.getAvailableAmount().intValue() + "\t");
        	if(orderModel.getMaxUserCreatedDate() > 0){
        		System.out.print(sdf.format(new Date(orderModel.getMaxUserCreatedDate())));
        	}else{
        		System.out.print(sdf.format(new Date()));
        	}
        	
        	System.out.print("\t");
        	System.out.print(orderModel.getPrice().divide(last,3, RoundingMode.HALF_DOWN));
        	System.out.print("\t");
        	System.out.print(orderModel.getAvailableAmount().multiply(last).intValue());
        	System.out.print("\t");
        	System.out.print(orderModel.getMinCompletedOrderQuantity());
        	System.out.print("\t");
    		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(orderModel.getCreatedDate())));

        }
        
        System.out.println();
        System.out.println();

        BigDecimal diffrence = TradingOrders.priceDifference(tradingOrderModel);
        BigDecimal buyPrice = TradingOrders.maxBuyPrice(tradingOrderModel);
        BigDecimal sellPrice = TradingOrders.minSellPrice(tradingOrderModel);

//        System.out.println(String.format("buyPrice %s, sellPrice %s, diffrence %s", buyPrice, sellPrice, diffrence));
//
//        Map<BigDecimal, BigDecimal> sellPriceBalanceMap = TradingOrders.sellPriceBalanceMap(tradingOrderModel);
//        try {
//            System.out.println("sellPriceBalanceMap :" + new ObjectMapper().writeValueAsString(sellPriceBalanceMap));
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
//
//        Map<BigDecimal, BigDecimal> buyPriceBalanceMap = TradingOrders.buyPriceBalanceMap(tradingOrderModel);
//        try {
//            System.out.println("buyPriceBalanceMap : " + new ObjectMapper().writeValueAsString(buyPriceBalanceMap));
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
//
//        Map<BigDecimal, Integer> sellPriceCountMap = TradingOrders.sellPriceCountMap(tradingOrderModel);
//        try {
//            System.out.println("sellPriceCountMap : " + new ObjectMapper().writeValueAsString(sellPriceCountMap));
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
//
//        Map<BigDecimal, Integer> buyPriceCountMap = TradingOrders.buyPriceCountMap(tradingOrderModel);
//        try {
//            System.out.println("buyPriceCountMap : " + new ObjectMapper().writeValueAsString(buyPriceCountMap));
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
    }
}
