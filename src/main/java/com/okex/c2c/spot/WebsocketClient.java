package com.okex.c2c.spot;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.apache.commons.compress.compressors.deflate64.Deflate64CompressorInputStream;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.okex.c2c.trading.constant.TradingOrderConstant;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;

@Component
public class WebsocketClient {
	
	private static Map<String, String> channelCurrencyMap = new HashMap<>();
	
	static{
		channelCurrencyMap.put("ok_sub_spot_btc_usdt_ticker", TradingOrderConstant.CURRENCY_BTC);
		channelCurrencyMap.put("ok_sub_spot_eth_usdt_ticker", TradingOrderConstant.CURRENCY_ETH);
		channelCurrencyMap.put("ok_sub_spot_eos_usdt_ticker", TradingOrderConstant.CURRENCY_EOS);
		channelCurrencyMap.put("ok_sub_spot_ltc_usdt_ticker", TradingOrderConstant.CURRENCY_LTC);
		channelCurrencyMap.put("ok_sub_spot_bch_usdt_ticker", TradingOrderConstant.CURRENCY_BCH);
		channelCurrencyMap.put("ok_sub_spot_etc_usdt_ticker", TradingOrderConstant.CURRENCY_ETC);
	}
	
	@PostConstruct
	public void init(){
		Thread thread = new Thread(()->{
			connect();
		}
		);
		thread.start();
	}

	public void connect() {
		OkHttpClient client = new OkHttpClient();

		Request request = new Request.Builder()
				.url("wss://okexcomreal.bafang.com:10441/websocket/okexapi?compress=true").build();

		client.newWebSocket(request, new WebSocketListener() {
			@Override
			public void onOpen(WebSocket webSocket, Response response) {
				webSocket.send("{\"channel\":\"ok_sub_spot_btc_usdt_ticker\",\"event\":\"addChannel\"}");
				webSocket.send("{\"channel\":\"ok_sub_spot_eth_usdt_ticker\",\"event\":\"addChannel\"}");
				webSocket.send("{\"channel\":\"ok_sub_spot_eos_usdt_ticker\",\"event\":\"addChannel\"}");
				webSocket.send("{\"channel\":\"ok_sub_spot_ltc_usdt_ticker\",\"event\":\"addChannel\"}");
				webSocket.send("{\"channel\":\"ok_sub_spot_bch_usdt_ticker\",\"event\":\"addChannel\"}");
				webSocket.send("{\"channel\":\"ok_sub_spot_etc_usdt_ticker\",\"event\":\"addChannel\"}");
			}

			@Override
			public void onMessage(WebSocket webSocket, String text) {
				
			}

			@Override
			public void onMessage(WebSocket webSocket, ByteString bytes) {
				String message = uncompress(bytes.toByteArray());
				ObjectMapper mapper = new ObjectMapper();
				try {
					TickerSpotResponse[] tickerSpotResponse = mapper.readValue(message, TickerSpotResponse[].class);
					String currency = channelCurrencyMap.get(tickerSpotResponse[0].getChannel());
					TickterSpotCache.tickterSpotMap.put(currency, tickerSpotResponse[0].getData());
//					System.out.println(message);
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
				System.out.println("连接关闭,code="+code+",reason="+reason);
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
