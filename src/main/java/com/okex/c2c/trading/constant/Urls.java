package com.okex.c2c.trading.constant;

public class Urls {
	
	private static final String OKEX_HOST = "https://www.okex.me/";

	public static final String TRADING_ORDERS_BOOK= OKEX_HOST + "v3/c2c/tradingOrders/book?side=all&baseCurrency=%s&quoteCurrency=cny&userType=certified&paymentMethod=all";
	
	public static final String TRADING_ORDERS_MY=OKEX_HOST + "v3/c2c/tradingOrders/my";
	
	public static final String TRADING_ORDERS_STOP = OKEX_HOST + "v3/c2c/tradingOrders/acceptOrder/stop";
	
	public static final String TRADING_ORDERS_START = OKEX_HOST + "v3/c2c/tradingOrders/acceptOrder/start"; 
	
}                                                                                                                                                                                                                                                      
