package com.okex.c2c.trading.service.model;

import java.math.BigDecimal;

public class OtcOrder {

	public static final int PLATFORM_OK = 1;

	public static final int PLATFORM_HUOBI = 2;

	private Integer platform;

	private String uid;

	private String userName;

	private BigDecimal price;

	private BigDecimal tradeCount;

	private BigDecimal maxTradeLimit;

	private BigDecimal minTradeLimit;

	public Integer getPlatform() {
		return platform;
	}

	public void setPlatform(Integer platform) {
		this.platform = platform;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getTradeCount() {
		return tradeCount;
	}

	public void setTradeCount(BigDecimal tradeCount) {
		this.tradeCount = tradeCount;
	}

	public BigDecimal getMaxTradeLimit() {
		return maxTradeLimit;
	}

	public void setMaxTradeLimit(BigDecimal maxTradeLimit) {
		this.maxTradeLimit = maxTradeLimit;
	}

	public BigDecimal getMinTradeLimit() {
		return minTradeLimit;
	}

	public void setMinTradeLimit(BigDecimal minTradeLimit) {
		this.minTradeLimit = minTradeLimit;
	}

}
