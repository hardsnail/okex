package com.okex.c2c.trading.web.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.okex.c2c.trading.service.HuobiUsdtDepthService;
import com.okex.c2c.trading.service.OkUsdtDepthService;
import com.okex.c2c.trading.web.model.UsdtDepthResult;

@Controller
@RequestMapping("api/usdtDepths")
public class UsdtDepthController {

	@Resource
	private OkUsdtDepthService okUsdtDepthService;

	@Resource
	private HuobiUsdtDepthService huobiUsdtDepthService;

	@GetMapping("ok")
	@ResponseBody
	public UsdtDepthResult ok() {
		return okUsdtDepthService.depth();
	}

	@GetMapping("huobi")
	@ResponseBody
	public UsdtDepthResult huobi() {
		return huobiUsdtDepthService.depth();
	}
}
