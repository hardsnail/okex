package com.okex.c2c.spot;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.compress.compressors.deflate64.Deflate64CompressorInputStream;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.okex.c2c.trading.constant.TradingOrderConstant;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;

public class Demo {

	private static Map<String, String> channelCurrencyMap = new HashMap<>();

	static {
		channelCurrencyMap.put("BTC-USDT", TradingOrderConstant.CURRENCY_BTC);
		channelCurrencyMap.put("EOS-USDT", TradingOrderConstant.CURRENCY_EOS);
		channelCurrencyMap.put("LTC-USDT", TradingOrderConstant.CURRENCY_LTC);
		channelCurrencyMap.put("BCH-USDT", TradingOrderConstant.CURRENCY_BCH);
		channelCurrencyMap.put("ETC-USDT", TradingOrderConstant.CURRENCY_ETC);
	}

	public static void main(String[] args) {
		connect();
	}

	public static void connect() {
		OkHttpClient client = new OkHttpClient();

		Request request = new Request.Builder().url("wss://okexcomreal.bafang.com:8443/ws/v3?compress=true").build();

		client.newWebSocket(request, new WebSocketListener() {
			@Override
			public void onOpen(WebSocket webSocket, Response response) {
				webSocket.send("{\"op\":\"subscribe\",\"args\":[\"spot/ticker:BTC-USDT\"]}");
			}

			@Override
			public void onMessage(WebSocket webSocket, String text) {

			}

			@Override
			public void onMessage(WebSocket webSocket, ByteString bytes) {
				String message = uncompress(bytes.toByteArray());
				ObjectMapper mapper = new ObjectMapper();
				try {
					JsonNode jsonNode = mapper.readTree(message);
					JsonNode tableJsonNode = jsonNode.get("table");
					if (tableJsonNode != null && tableJsonNode.asText().equals("spot/ticker")) {
						JsonNode dataJsonNode = jsonNode.get("data");
						if (dataJsonNode != null) {
							dataJsonNode.forEach((JsonNode data) -> {
								String instrument_id = data.get("instrument_id").asText();
								BigDecimal last = new BigDecimal(data.get("last").asText());
								String currency = channelCurrencyMap.get(instrument_id);
								TickterSpot tickterSpot = new TickterSpot();
								tickterSpot.setLast(last);
								TickterSpotCache.tickterSpotMap.put(currency, tickterSpot);
							});
						}
					}

					System.out.println(message);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			@Override
			public void onFailure(WebSocket webSocket, Throwable t, Response response) {
				connect();
			}

			@Override
			public void onClosed(WebSocket webSocket, int code, String reason) {
				System.out.println("连接关闭,code=" + code + ",reason=" + reason);
				super.onClosed(webSocket, code, reason);
			}
		});
	}

	private static String uncompress(byte[] bytes) {
		try (final ByteArrayOutputStream out = new ByteArrayOutputStream();
				final ByteArrayInputStream in = new ByteArrayInputStream(bytes);
				final Deflate64CompressorInputStream zin = new Deflate64CompressorInputStream(in)) {
			final byte[] buffer = new byte[1024];
			int offset;
			while (-1 != (offset = zin.read(buffer))) {
				out.write(buffer, 0, offset);
			}
			return out.toString();
		} catch (final IOException e) {
			throw new RuntimeException(e);
		}
	}
}
