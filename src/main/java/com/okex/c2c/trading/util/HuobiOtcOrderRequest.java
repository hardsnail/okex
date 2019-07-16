package com.okex.c2c.trading.util;

import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.Header;
import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Request;
import org.apache.http.message.BasicHeader;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.okex.c2c.trading.service.model.OtcOrder;

public class HuobiOtcOrderRequest {

	public static final String TRADE_TYPE_BUY = "buy";

	public static final String COOKIE = "acw_tc=0bc1a04415623801149258079e3761931ab13096f3156fb43583d70582572e";

	public static final String URL = "https://otc-api.eiijo.cn/v1/data/trade-market?coinId=2&currency=1&tradeType=%s&currPage=%s&payMethod=0&country=37&blockType=general&online=1&range=0&amount=";

	public static final String USER_AGENT = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3824.6 Safari/537.36";

	public static List<OtcOrder> buyOrderList() {
		List<OtcOrder> result = new ArrayList<>();
		Integer currPage = 1;
		while(currPage <30) {
			JsonNode jsonNode = request("buy", currPage);
			if (jsonNode == null || currPage > jsonNode.findValue("totalPage").asInt()) {
				break;
			}

			JsonNode dataJsonNode = jsonNode.findValue("data");
			addOrder(result, dataJsonNode);
			currPage++;
			try {
				Thread.sleep(300l);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}

	public static List<OtcOrder> sellOrderList() {
		List<OtcOrder> result = new ArrayList<>();
		Integer currPage = 1;
		while (currPage < 30) {
			JsonNode jsonNode = request("sell", currPage);
			if (jsonNode == null || currPage > jsonNode.findValue("totalPage").asInt()) {
				break;
			}

			JsonNode dataJsonNode = jsonNode.findValue("data");
			addOrder(result, dataJsonNode);
			currPage++;
			try {
				Thread.sleep(100l);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		return result;
	}
	
	private static void addOrder(List<OtcOrder> otcOrderList, JsonNode dataJsonNode) {
		if (dataJsonNode.isArray()) {
			dataJsonNode.forEach((JsonNode node) -> {
				OtcOrder otcOrder = new OtcOrder();
				otcOrder.setMaxTradeLimit(new BigDecimal(node.get("maxTradeLimit").asText()));
				otcOrder.setMinTradeLimit(new BigDecimal(node.get("minTradeLimit").asText()));
				otcOrder.setPlatform(OtcOrder.PLATFORM_HUOBI);
				otcOrder.setPrice(new BigDecimal(node.get("price").asText()));
				otcOrder.setTradeCount(new BigDecimal(node.get("tradeCount").asText()));
				otcOrder.setUid(node.get("uid").asText());
				otcOrder.setUserName(node.get("userName").asText());
				otcOrderList.add(otcOrder);
			});
		}
	}

	private static JsonNode request(String tradeType, Integer currPage) {
		try {
			Header cookieHeader = new BasicHeader("Cookie", COOKIE);
			Header userAgentHeader = new BasicHeader("User-Agent", USER_AGENT);
			Content content = Request.Get(String.format(URL, tradeType, currPage)).addHeader(cookieHeader).addHeader(userAgentHeader).execute().returnContent();
			String s = content.asString(Charset.defaultCharset());
			ObjectMapper om = new ObjectMapper();
			return om.readTree(s);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
