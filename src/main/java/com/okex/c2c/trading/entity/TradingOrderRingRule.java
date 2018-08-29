package com.okex.c2c.trading.entity;

public class TradingOrderRingRule {

    public static final int TYPE_SELL = 1;

    public static final int TYPE_BUY = 2;

    private Integer type;

    private Boolean enabled;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

}
