package com.okex.c2c.trading.service.impl;

import org.springframework.stereotype.Service;

import com.okex.c2c.trading.service.HuobiUsdtDepthService;
import com.okex.c2c.trading.util.HuobiOtcOrderRequest;
import com.okex.c2c.trading.web.model.UsdtDepthResult;

@Service
public class HuobiUsdtDepthServiceImpl implements HuobiUsdtDepthService {

	@Override
	public UsdtDepthResult depth() {
		return UsdtDepthResult.create(HuobiOtcOrderRequest.sellOrderList(), HuobiOtcOrderRequest.buyOrderList());
	}

}
