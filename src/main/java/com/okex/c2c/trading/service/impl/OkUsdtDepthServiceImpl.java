package com.okex.c2c.trading.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.okex.c2c.trading.component.TradingOrderContext;
import com.okex.c2c.trading.constant.TradingOrderConstant;
import com.okex.c2c.trading.service.OkUsdtDepthService;
import com.okex.c2c.trading.util.TradingOrders;
import com.okex.c2c.trading.web.model.TradingOrderModel;
import com.okex.c2c.trading.web.model.UsdtDepthModel;
import com.okex.c2c.trading.web.model.UsdtDepthResult;

@Service
public class OkUsdtDepthServiceImpl implements OkUsdtDepthService {

	@Resource
	private TradingOrderContext tradingOrderContext;

	@Override
	public UsdtDepthResult depth() {
		UsdtDepthResult result = new UsdtDepthResult();
		TradingOrderModel model = tradingOrderContext.currentTrading(TradingOrderConstant.CURRENCY_USDT);

		BigDecimal buyUsdtCount = BigDecimal.ZERO;
		List<UsdtDepthModel> buyList = new ArrayList<>();
		Map<BigDecimal, BigDecimal> buyBalanceMap = TradingOrders.buyPriceBalanceMap(model);
		Map<BigDecimal, Integer> buyCountMap = TradingOrders.buyPriceCountMap(model);
		Set<BigDecimal> buyKeySet = buyBalanceMap.keySet();
		int buyIndex = 1;
		for (BigDecimal key : buyKeySet) {
			UsdtDepthModel usdtDepthModel = new UsdtDepthModel();
			Integer count = buyCountMap.get(key);
			BigDecimal usdtCount = buyBalanceMap.get(key);
			usdtDepthModel.setPrice(key);
			usdtDepthModel.setCount(count);
			usdtDepthModel.setUsdtCount(usdtCount);
			usdtDepthModel.setIndex(buyIndex++);
			buyList.add(usdtDepthModel);
			buyUsdtCount = buyUsdtCount.add(usdtCount);
		}

		BigDecimal sellUsdtCount = BigDecimal.ZERO;

		List<UsdtDepthModel> sellList = new ArrayList<>();
		Map<BigDecimal, BigDecimal> sellBalanceMap = TradingOrders.sellPriceBalanceMap(model);
		Map<BigDecimal, Integer> sellCountMap = TradingOrders.sellPriceCountMap(model);
		Set<BigDecimal> sellKeySet = sellBalanceMap.keySet();
		int sellIndex = sellKeySet.size();
		for (BigDecimal key : sellKeySet) {
			UsdtDepthModel usdtDepthModel = new UsdtDepthModel();
			Integer count = sellCountMap.get(key);
			BigDecimal usdtCount = sellBalanceMap.get(key);
			usdtDepthModel.setPrice(key);
			usdtDepthModel.setCount(count);
			usdtDepthModel.setUsdtCount(usdtCount);
			usdtDepthModel.setIndex(sellIndex--);
			sellList.add(usdtDepthModel);
			sellUsdtCount = sellUsdtCount.add(usdtCount);
		}

		result.setBuyList(buyList);
		result.setBuyUsdtCount(buyUsdtCount);
		result.setSellList(sellList);
		result.setSellUsdtCount(sellUsdtCount);
		result.setSysdate(new Date());
		return result;
	}

}
