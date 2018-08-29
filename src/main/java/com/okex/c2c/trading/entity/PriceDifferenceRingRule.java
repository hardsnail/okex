package com.okex.c2c.trading.entity;

import java.math.BigDecimal;

import javax.persistence.Id;

public class PriceDifferenceRingRule {

    public static final String SYMBOL_LT = "lt";

    public static final String SYMBOL_EQ = "eq";

    public static final String SYMBOL_GT = "gt";

    @Id
    private Long id;

    private String quoteCurrency;

    private String symbol;

    private BigDecimal value;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuoteCurrency() {
        return quoteCurrency;
    }

    public void setQuoteCurrency(String quoteCurrency) {
        this.quoteCurrency = quoteCurrency;
    }

}
