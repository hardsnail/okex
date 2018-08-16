package com.okex.c2c.trading.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.okex.c2c.trading.web.model.TradingOrderModel;
import com.okex.c2c.web.Result;

@Controller
@RequestMapping("tradingOrders")
public class TradingOrderController {

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Result<TradingOrderModel> get() {
        int i = 0;
        int j = 1;
        System.out.println(j / i);
        return Result.success(new TradingOrderModel());
    }
}
