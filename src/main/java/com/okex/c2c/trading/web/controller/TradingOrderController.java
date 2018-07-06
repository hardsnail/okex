package com.okex.c2c.trading.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.okex.c2c.trading.web.model.TradingOrderModel;

@Controller
@RequestMapping("tradingOrders")
public class TradingOrderController {


    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public TradingOrderModel get() {
        return new TradingOrderModel();
    }
}
