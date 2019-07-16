package com.okex.c2c.trading.web.model;

import java.math.BigDecimal;

public class UsdtDepthModel implements Comparable<UsdtDepthModel> {

	private Integer index;

	private BigDecimal price;

	private Integer count;

	private BigDecimal usdtCount;

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	@Override
	public int compareTo(UsdtDepthModel o) {
		return price.compareTo(o.getPrice());
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	public BigDecimal getUsdtCount() {
		return usdtCount;
	}

	public void setUsdtCount(BigDecimal usdtCount) {
		this.usdtCount = usdtCount;
	}

}
