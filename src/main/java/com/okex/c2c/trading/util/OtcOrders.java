package com.okex.c2c.trading.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.okex.c2c.trading.service.model.OtcOrder;

public class OtcOrders {
	public static Map<BigDecimal, BigDecimal> balanceMap(List<OtcOrder> orderList) {
		Map<BigDecimal, BigDecimal> result = new TreeMap<>((o1, o2) -> -o1.compareTo(o2));
		if (orderList.isEmpty()) {
			return result;
		}
		for (OtcOrder otcOrder : orderList) {
			BigDecimal balance = result.get(otcOrder.getPrice());
			BigDecimal maxTradeBalance = otcOrder.getMaxTradeLimit().divide(otcOrder.getPrice(), 1, RoundingMode.HALF_UP);
			if (balance == null) {
				result.put(otcOrder.getPrice(), maxTradeBalance);
			} else {
				result.put(otcOrder.getPrice(), balance.add(maxTradeBalance));
			}
		}
		return result;
	}

	public static Map<BigDecimal, Integer> countMap(List<OtcOrder> orderList) {
		Map<BigDecimal, Integer> result = new TreeMap<>((o1, o2) -> -o1.compareTo(o2));
		if (orderList.isEmpty()) {
			return result;
		}
		for (OtcOrder otcOrder : orderList) {
			Integer count = result.get(otcOrder.getPrice());
			if (count == null) {
				result.put(otcOrder.getPrice(), 1);
			} else {
				result.put(otcOrder.getPrice(), count + 1);
			}
		}
		return result;
	}

}
