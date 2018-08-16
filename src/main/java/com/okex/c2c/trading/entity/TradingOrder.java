package com.okex.c2c.trading.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class TradingOrder implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    private Long id;

    private Boolean acceptOrder;

    private BigDecimal availableAmount;

    private String availableFromTime;

    private String availableToTime;

    private Integer best;

    private Boolean blacker;

    private Boolean canPlaceOrder;

    private Integer clientAvgCompletedSeconds;

    private String clientAvgCompletedTime;

    private Integer clientAvgPaidSeconds;

    private String clientAvgPaidTime;

    private Integer clientCancelledOrderQuantity;

    private Integer clientCompletedOrderQuantity;

    private Integer clientCompletionSecondsAvg;

    private Integer clientKycLevel;

    private String clientName;

    private Integer clientPaymentSecondsAvg;

    private BigDecimal completedAmount;

    private Integer completedOrderQuantity;

    private BigDecimal completedOrderTotal;

    private Long createdDate;

    private Boolean diamondUser;

    private String digitalCurrencySymbol;

    private BigDecimal exchangeRate;

    private Boolean exchangeRateDeviateTooFar;

    private Boolean existPhone;

    private Integer floatRate;

    private Integer frozenAmount;

    private Integer index;

    private Boolean isBuy;

    private String legalCurrencySymbol;

    private Integer maxPlacePrice;

    private Integer minKycLevel;

    private Integer minPlacePrice;

    private String notes;

    private Long publicTradingOrderId;

    private Integer type;

    @Transient
    @JsonIgnoreProperties
    private List<String> paySupport;

    public Boolean getAcceptOrder() {
        return acceptOrder;
    }

    public void setAcceptOrder(Boolean acceptOrder) {
        this.acceptOrder = acceptOrder;
    }

    public BigDecimal getAvailableAmount() {
        return availableAmount;
    }

    public void setAvailableAmount(BigDecimal availableAmount) {
        this.availableAmount = availableAmount;
    }

    public String getAvailableFromTime() {
        return availableFromTime;
    }

    public void setAvailableFromTime(String availableFromTime) {
        this.availableFromTime = availableFromTime;
    }

    public String getAvailableToTime() {
        return availableToTime;
    }

    public void setAvailableToTime(String availableToTime) {
        this.availableToTime = availableToTime;
    }

    public Integer getBest() {
        return best;
    }

    public void setBest(Integer best) {
        this.best = best;
    }

    public Boolean getBlacker() {
        return blacker;
    }

    public void setBlacker(Boolean blacker) {
        this.blacker = blacker;
    }

    public Boolean getCanPlaceOrder() {
        return canPlaceOrder;
    }

    public void setCanPlaceOrder(Boolean canPlaceOrder) {
        this.canPlaceOrder = canPlaceOrder;
    }

    public Integer getClientAvgCompletedSeconds() {
        return clientAvgCompletedSeconds;
    }

    public void setClientAvgCompletedSeconds(Integer clientAvgCompletedSeconds) {
        this.clientAvgCompletedSeconds = clientAvgCompletedSeconds;
    }

    public String getClientAvgCompletedTime() {
        return clientAvgCompletedTime;
    }

    public void setClientAvgCompletedTime(String clientAvgCompletedTime) {
        this.clientAvgCompletedTime = clientAvgCompletedTime;
    }

    public Integer getClientAvgPaidSeconds() {
        return clientAvgPaidSeconds;
    }

    public void setClientAvgPaidSeconds(Integer clientAvgPaidSeconds) {
        this.clientAvgPaidSeconds = clientAvgPaidSeconds;
    }

    public String getClientAvgPaidTime() {
        return clientAvgPaidTime;
    }

    public void setClientAvgPaidTime(String clientAvgPaidTime) {
        this.clientAvgPaidTime = clientAvgPaidTime;
    }

    public Integer getClientCancelledOrderQuantity() {
        return clientCancelledOrderQuantity;
    }

    public void setClientCancelledOrderQuantity(Integer clientCancelledOrderQuantity) {
        this.clientCancelledOrderQuantity = clientCancelledOrderQuantity;
    }

    public Integer getClientCompletedOrderQuantity() {
        return clientCompletedOrderQuantity;
    }

    public void setClientCompletedOrderQuantity(Integer clientCompletedOrderQuantity) {
        this.clientCompletedOrderQuantity = clientCompletedOrderQuantity;
    }

    public Integer getClientCompletionSecondsAvg() {
        return clientCompletionSecondsAvg;
    }

    public void setClientCompletionSecondsAvg(Integer clientCompletionSecondsAvg) {
        this.clientCompletionSecondsAvg = clientCompletionSecondsAvg;
    }

    public Integer getClientKycLevel() {
        return clientKycLevel;
    }

    public void setClientKycLevel(Integer clientKycLevel) {
        this.clientKycLevel = clientKycLevel;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public Integer getClientPaymentSecondsAvg() {
        return clientPaymentSecondsAvg;
    }

    public void setClientPaymentSecondsAvg(Integer clientPaymentSecondsAvg) {
        this.clientPaymentSecondsAvg = clientPaymentSecondsAvg;
    }

    public BigDecimal getCompletedAmount() {
        return completedAmount;
    }

    public void setCompletedAmount(BigDecimal completedAmount) {
        this.completedAmount = completedAmount;
    }

    public Integer getCompletedOrderQuantity() {
        return completedOrderQuantity;
    }

    public void setCompletedOrderQuantity(Integer completedOrderQuantity) {
        this.completedOrderQuantity = completedOrderQuantity;
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

    public Boolean getDiamondUser() {
        return diamondUser;
    }

    public void setDiamondUser(Boolean diamondUser) {
        this.diamondUser = diamondUser;
    }

    public String getDigitalCurrencySymbol() {
        return digitalCurrencySymbol;
    }

    public void setDigitalCurrencySymbol(String digitalCurrencySymbol) {
        this.digitalCurrencySymbol = digitalCurrencySymbol;
    }

    public BigDecimal getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(BigDecimal exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public Boolean getExchangeRateDeviateTooFar() {
        return exchangeRateDeviateTooFar;
    }

    public void setExchangeRateDeviateTooFar(Boolean exchangeRateDeviateTooFar) {
        this.exchangeRateDeviateTooFar = exchangeRateDeviateTooFar;
    }

    public Boolean getExistPhone() {
        return existPhone;
    }

    public void setExistPhone(Boolean existPhone) {
        this.existPhone = existPhone;
    }

    public Integer getFloatRate() {
        return floatRate;
    }

    public void setFloatRate(Integer floatRate) {
        this.floatRate = floatRate;
    }

    public Integer getFrozenAmount() {
        return frozenAmount;
    }

    public void setFrozenAmount(Integer frozenAmount) {
        this.frozenAmount = frozenAmount;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public Boolean getIsBuy() {
        return isBuy;
    }

    public void setIsBuy(Boolean isBuy) {
        this.isBuy = isBuy;
    }

    public String getLegalCurrencySymbol() {
        return legalCurrencySymbol;
    }

    public void setLegalCurrencySymbol(String legalCurrencySymbol) {
        this.legalCurrencySymbol = legalCurrencySymbol;
    }

    public Integer getMaxPlacePrice() {
        return maxPlacePrice;
    }

    public void setMaxPlacePrice(Integer maxPlacePrice) {
        this.maxPlacePrice = maxPlacePrice;
    }

    public Integer getMinKycLevel() {
        return minKycLevel;
    }

    public void setMinKycLevel(Integer minKycLevel) {
        this.minKycLevel = minKycLevel;
    }

    public Integer getMinPlacePrice() {
        return minPlacePrice;
    }

    public void setMinPlacePrice(Integer minPlacePrice) {
        this.minPlacePrice = minPlacePrice;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Long getPublicTradingOrderId() {
        return publicTradingOrderId;
    }

    public void setPublicTradingOrderId(Long publicTradingOrderId) {
        this.publicTradingOrderId = publicTradingOrderId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<String> getPaySupport() {
        return paySupport;
    }

    public void setPaySupport(List<String> paySupport) {
        this.paySupport = paySupport;
    }

}
