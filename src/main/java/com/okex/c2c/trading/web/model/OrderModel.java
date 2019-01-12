package com.okex.c2c.trading.web.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class OrderModel {

	private BigDecimal availableAmount;
	
	private String baseCurrency;
	
	private Boolean blocked;
	
	private Integer completedAmount;
	
	private BigDecimal completedOrderTotal;
	
	private Long createdDate;
	
	private UserModel creator;
	
	private Boolean exchangeRateDeviateTooFar;
	
	public Boolean getIsBlockTrade() {
		return isBlockTrade;
	}

	public void setIsBlockTrade(Boolean isBlockTrade) {
		this.isBlockTrade = isBlockTrade;
	}

	private BigDecimal floatRate;
	
	private Boolean hidden;
	
	private BigDecimal holdAmount;
	
	private Boolean isBlockTrade;
	
	private Integer index;
	
	private Integer maxAvgCompleteTime;
	
	private Integer maxAvgPaymentTime;
	
	private Long maxUserCreatedDate;
	
	private Integer minCompletedOrderQuantity;
	
	private Integer minCompletionRate;
	
	private Integer minKycLevel;
	
	private Boolean mine;
	
	@Transient
    @JsonIgnoreProperties
    private List<String> paymentMethods;
	
	private BigDecimal price;
	
	private String publicId;
	
	private String quoteCurrency;
	
	private BigDecimal quoteMaxAmountPerOrder;
	
	private BigDecimal quoteMinAmountPerOrder;
	
	private String remark;
	
	private String side;
	
	private String type;
	
	private String userType;
	
	public BigDecimal getAvailableAmount() {
		return availableAmount;
	}

	public void setAvailableAmount(BigDecimal availableAmount) {
		this.availableAmount = availableAmount;
	}

	public String getBaseCurrency() {
		return baseCurrency;
	}

	public void setBaseCurrency(String baseCurrency) {
		this.baseCurrency = baseCurrency;
	}

	public Boolean getBlocked() {
		return blocked;
	}

	public void setBlocked(Boolean blocked) {
		this.blocked = blocked;
	}

	public Integer getCompletedAmount() {
		return completedAmount;
	}

	public void setCompletedAmount(Integer completedAmount) {
		this.completedAmount = completedAmount;
	}

	public BigDecimal getCompletedOrderTotal() {
		return completedOrderTotal;
	}

	public void setCompletedOrderTotal(BigDecimal completedOrderTotal) {
		this.completedOrderTotal = completedOrderTotal;
	}

	public Long getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Long createdDate) {
		this.createdDate = createdDate;
	}

	public UserModel getCreator() {
		return creator;
	}

	public void setCreator(UserModel creator) {
		this.creator = creator;
	}

	public Boolean getExchangeRateDeviateTooFar() {
		return exchangeRateDeviateTooFar;
	}

	public void setExchangeRateDeviateTooFar(Boolean exchangeRateDeviateTooFar) {
		this.exchangeRateDeviateTooFar = exchangeRateDeviateTooFar;
	}

	public BigDecimal getFloatRate() {
		return floatRate;
	}

	public void setFloatRate(BigDecimal floatRate) {
		this.floatRate = floatRate;
	}

	public Boolean getHidden() {
		return hidden;
	}

	public void setHidden(Boolean hidden) {
		this.hidden = hidden;
	}

	public BigDecimal getHoldAmount() {
		return holdAmount;
	}

	public void setHoldAmount(BigDecimal holdAmount) {
		this.holdAmount = holdAmount;
	}

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	public Integer getMaxAvgCompleteTime() {
		return maxAvgCompleteTime;
	}

	public void setMaxAvgCompleteTime(Integer maxAvgCompleteTime) {
		this.maxAvgCompleteTime = maxAvgCompleteTime;
	}

	public Integer getMaxAvgPaymentTime() {
		return maxAvgPaymentTime;
	}

	public void setMaxAvgPaymentTime(Integer maxAvgPaymentTime) {
		this.maxAvgPaymentTime = maxAvgPaymentTime;
	}

	public Long getMaxUserCreatedDate() {
		return maxUserCreatedDate;
	}

	public void setMaxUserCreatedDate(Long maxUserCreatedDate) {
		this.maxUserCreatedDate = maxUserCreatedDate;
	}

	public Integer getMinCompletedOrderQuantity() {
		return minCompletedOrderQuantity;
	}

	public void setMinCompletedOrderQuantity(Integer minCompletedOrderQuantity) {
		this.minCompletedOrderQuantity = minCompletedOrderQuantity;
	}

	public Integer getMinCompletionRate() {
		return minCompletionRate;
	}

	public void setMinCompletionRate(Integer minCompletionRate) {
		this.minCompletionRate = minCompletionRate;
	}

	public Integer getMinKycLevel() {
		return minKycLevel;
	}

	public void setMinKycLevel(Integer minKycLevel) {
		this.minKycLevel = minKycLevel;
	}

	public Boolean getMine() {
		return mine;
	}

	public void setMine(Boolean mine) {
		this.mine = mine;
	}

	public List<String> getPaymentMethods() {
		return paymentMethods;
	}

	public void setPaymentMethods(List<String> paymentMethods) {
		this.paymentMethods = paymentMethods;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getPublicId() {
		return publicId;
	}

	public void setPublicId(String publicId) {
		this.publicId = publicId;
	}

	public String getQuoteCurrency() {
		return quoteCurrency;
	}

	public void setQuoteCurrency(String quoteCurrency) {
		this.quoteCurrency = quoteCurrency;
	}

	public BigDecimal getQuoteMaxAmountPerOrder() {
		return quoteMaxAmountPerOrder;
	}

	public void setQuoteMaxAmountPerOrder(BigDecimal quoteMaxAmountPerOrder) {
		this.quoteMaxAmountPerOrder = quoteMaxAmountPerOrder;
	}

	public BigDecimal getQuoteMinAmountPerOrder() {
		return quoteMinAmountPerOrder;
	}

	public void setQuoteMinAmountPerOrder(BigDecimal quoteMinAmountPerOrder) {
		this.quoteMinAmountPerOrder = quoteMinAmountPerOrder;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getSide() {
		return side;
	}

	public void setSide(String side) {
		this.side = side;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

}
