package com.okex.c2c.trading.parameter;

import java.math.BigDecimal;

public class TradingOrderAdd {

	private String side;
	
	private String baseCurrency;
	
	private String quoteCurrency;
	
	private String type;
	
	private Long baseAmount;
	
	private Long quoteMinAmountPerOrder;
	
	private Long quoteMaxAmountPerOrder;
	
	private String remark;
	
	private String userType;
	
	private BigDecimal minCompletionRate;
	
	private Integer minCompletedOrderQuantity;
	
	private Integer minKycLevel;
	
	private Boolean isBlockTrade;
	
	private String price;
	
	private Long maxUserCreatedDate;

	public String getSide() {
		return side;
	}

	public void setSide(String side) {
		this.side = side;
	}

	public String getBaseCurrency() {
		return baseCurrency;
	}

	public void setBaseCurrency(String baseCurrency) {
		this.baseCurrency = baseCurrency;
	}

	public String getQuoteCurrency() {
		return quoteCurrency;
	}

	public void setQuoteCurrency(String quoteCurrency) {
		this.quoteCurrency = quoteCurrency;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getBaseAmount() {
		return baseAmount;
	}

	public void setBaseAmount(Long baseAmount) {
		this.baseAmount = baseAmount;
	}

	public Long getQuoteMinAmountPerOrder() {
		return quoteMinAmountPerOrder;
	}

	public void setQuoteMinAmountPerOrder(Long quoteMinAmountPerOrder) {
		this.quoteMinAmountPerOrder = quoteMinAmountPerOrder;
	}

	public Long getQuoteMaxAmountPerOrder() {
		return quoteMaxAmountPerOrder;
	}

	public void setQuoteMaxAmountPerOrder(Long quoteMaxAmountPerOrder) {
		this.quoteMaxAmountPerOrder = quoteMaxAmountPerOrder;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public BigDecimal getMinCompletionRate() {
		return minCompletionRate;
	}

	public void setMinCompletionRate(BigDecimal minCompletionRate) {
		this.minCompletionRate = minCompletionRate;
	}

	public Integer getMinCompletedOrderQuantity() {
		return minCompletedOrderQuantity;
	}

	public void setMinCompletedOrderQuantity(Integer minCompletedOrderQuantity) {
		this.minCompletedOrderQuantity = minCompletedOrderQuantity;
	}

	public Integer getMinKycLevel() {
		return minKycLevel;
	}

	public void setMinKycLevel(Integer minKycLevel) {
		this.minKycLevel = minKycLevel;
	}

	public Boolean getIsBlockTrade() {
		return isBlockTrade;
	}

	public void setIsBlockTrade(Boolean isBlockTrade) {
		this.isBlockTrade = isBlockTrade;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Long getMaxUserCreatedDate() {
		return maxUserCreatedDate;
	}

	public void setMaxUserCreatedDate(Long maxUserCreatedDate) {
		this.maxUserCreatedDate = maxUserCreatedDate;
	}
	
}
