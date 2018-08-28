package com.okex.c2c.trading.web.model;

import java.math.BigDecimal;

public class UserModel {
	
	private String acceptState;
	
	private Boolean agreedTos;
	
	private Integer avgCompleteTime;
	
	private Integer avgPaymentTime;
	
	private Boolean boundBankCard;
	
	private Boolean boundPhoneNumber;
	
	private Integer cancelledOrderQuantity;
	
	private Integer completedOrderQuantity;
	
	private BigDecimal completionRate;
	
	private Long createdDate;
	
	private Boolean disabled;
	
	private Integer kycLevel;
	
	private String nickName;
	
	private String realName;
	
	private String type;

	public String getAcceptState() {
		return acceptState;
	}

	public void setAcceptState(String acceptState) {
		this.acceptState = acceptState;
	}

	public Boolean getAgreedTos() {
		return agreedTos;
	}

	public void setAgreedTos(Boolean agreedTos) {
		this.agreedTos = agreedTos;
	}

	public Integer getAvgCompleteTime() {
		return avgCompleteTime;
	}

	public void setAvgCompleteTime(Integer avgCompleteTime) {
		this.avgCompleteTime = avgCompleteTime;
	}

	public Integer getAvgPaymentTime() {
		return avgPaymentTime;
	}

	public void setAvgPaymentTime(Integer avgPaymentTime) {
		this.avgPaymentTime = avgPaymentTime;
	}

	public Boolean getBoundBankCard() {
		return boundBankCard;
	}

	public void setBoundBankCard(Boolean boundBankCard) {
		this.boundBankCard = boundBankCard;
	}

	public Boolean getBoundPhoneNumber() {
		return boundPhoneNumber;
	}

	public void setBoundPhoneNumber(Boolean boundPhoneNumber) {
		this.boundPhoneNumber = boundPhoneNumber;
	}

	public Integer getCancelledOrderQuantity() {
		return cancelledOrderQuantity;
	}

	public void setCancelledOrderQuantity(Integer cancelledOrderQuantity) {
		this.cancelledOrderQuantity = cancelledOrderQuantity;
	}

	public Integer getCompletedOrderQuantity() {
		return completedOrderQuantity;
	}

	public void setCompletedOrderQuantity(Integer completedOrderQuantity) {
		this.completedOrderQuantity = completedOrderQuantity;
	}

	public BigDecimal getCompletionRate() {
		return completionRate;
	}

	public void setCompletionRate(BigDecimal completionRate) {
		this.completionRate = completionRate;
	}

	public Long getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Long createdDate) {
		this.createdDate = createdDate;
	}

	public Boolean getDisabled() {
		return disabled;
	}

	public void setDisabled(Boolean disabled) {
		this.disabled = disabled;
	}

	public Integer getKycLevel() {
		return kycLevel;
	}

	public void setKycLevel(Integer kycLevel) {
		this.kycLevel = kycLevel;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
