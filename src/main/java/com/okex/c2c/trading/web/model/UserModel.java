package com.okex.c2c.trading.web.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserModel {
	
	private String acceptState;
	
	private Boolean agreedTos;
	
	private Boolean boundBankCard;
	
	private Boolean boundPhoneNumber;
	
	private BigDecimal completionRate;
	
	private Long createdDate;
	
	private Boolean disabled;
	
	private Integer kycLevel;
	
	private String nickName;
	
	private String realName;
	
	private String type;

	private Boolean strategyDisabled;
	
	private String strategyDisabledReason;
	
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

	public Boolean getStrategyDisabled() {
		return strategyDisabled;
	}

	public void setStrategyDisabled(Boolean strategyDisabled) {
		this.strategyDisabled = strategyDisabled;
	}

	public String getStrategyDisabledReason() {
		return strategyDisabledReason;
	}

	public void setStrategyDisabledReason(String strategyDisabledReason) {
		this.strategyDisabledReason = strategyDisabledReason;
	}

}
