package com.okex.c2c.trading.web.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.okex.c2c.trading.service.model.OtcOrder;
import com.okex.c2c.trading.util.OtcOrders;

public class UsdtDepthResult {

	private List<UsdtDepthModel> sellList;

	private List<UsdtDepthModel> buyList;

	private BigDecimal sellUsdtCount;

	private BigDecimal buyUsdtCount;

	private Date sysdate;

	public List<UsdtDepthModel> getSellList() {
		return sellList;
	}

	public void setSellList(List<UsdtDepthModel> sellList) {
		this.sellList = sellList;
	}

	public List<UsdtDepthModel> getBuyList() {
		return buyList;
	}

	public void setBuyList(List<UsdtDepthModel> buyList) {
		this.buyList = buyList;
	}

	public BigDecimal getSellUsdtCount() {
		return sellUsdtCount;
	}

	public void setSellUsdtCount(BigDecimal sellUsdtCount) {
		this.sellUsdtCount = sellUsdtCount;
	}

	public BigDecimal getBuyUsdtCount() {
		return buyUsdtCount;
	}

	public void setBuyUsdtCount(BigDecimal buyUsdtCount) {
		this.buyUsdtCount = buyUsdtCount;
	}

	public Date getSysdate() {
		return sysdate;
	}

	public void setSysdate(Date sysdate) {
		this.sysdate = sysdate;
	}

	public static UsdtDepthResult create(List<OtcOrder> sellOrderList, List<OtcOrder> buyOrderList) {
		UsdtDepthResult result = new UsdtDepthResult();

		BigDecimal sellUsdtCount = BigDecimal.ZERO;
		List<UsdtDepthModel> sellList = new ArrayList<>();
		Map<BigDecimal, BigDecimal> sellBalanceMap = OtcOrders.balanceMap(sellOrderList);
		Map<BigDecimal, Integer> sellCountMap = OtcOrders.countMap(sellOrderList);
		int sellIndex = sellBalanceMap.size();
		for (BigDecimal price : sellBalanceMap.keySet()) {
			UsdtDepthModel usdtDepthModel = new UsdtDepthModel();
			usdtDepthModel.setCount(sellCountMap.get(price));
			usdtDepthModel.setIndex(sellIndex--);
			usdtDepthModel.setPrice(price);
			usdtDepthModel.setUsdtCount(sellBalanceMap.get(price));
			if (sellIndex > 3) {
				continue;
			}
			sellList.add(usdtDepthModel);
			sellUsdtCount.add(new BigDecimal(sellCountMap.get(price)));
		}

		BigDecimal buyUsdtCount = BigDecimal.ZERO;
		List<UsdtDepthModel> buyList = new ArrayList<>();
		Map<BigDecimal, BigDecimal> buyBalanceMap = OtcOrders.balanceMap(buyOrderList);
		Map<BigDecimal, Integer> buyCountMap = OtcOrders.countMap(buyOrderList);
		int buyIndex = 1;
		for (BigDecimal price : buyBalanceMap.keySet()) {
			UsdtDepthModel usdtDepthModel = new UsdtDepthModel();
			usdtDepthModel.setCount(buyCountMap.get(price));
			usdtDepthModel.setIndex(buyIndex++);
			usdtDepthModel.setPrice(price);
			usdtDepthModel.setUsdtCount(buyBalanceMap.get(price));
			buyList.add(usdtDepthModel);
			buyUsdtCount.add(new BigDecimal(buyCountMap.get(price)));
			if (buyIndex > 3) {
				break;
			}
		}

		result.setBuyUsdtCount(buyUsdtCount);
		result.setSellUsdtCount(sellUsdtCount);
		result.setBuyList(buyList);
		result.setSellList(sellList);
		result.setSysdate(new Date());
		return result;
	}
}
