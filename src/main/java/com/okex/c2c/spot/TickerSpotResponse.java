package com.okex.c2c.spot;

public class TickerSpotResponse {
	
	public static final String CHANNEL_BTC="ok_sub_spot_btc_usdt_ticker";
	public static final String CHANNEL_ETH="ok_sub_spot_eth_usdt_ticker";
	public static final String CHANNEL_EOS="ok_sub_spot_eos_usdt_ticker";
	public static final String CHANNEL_LTC="ok_sub_spot_ltc_usdt_ticker";
	public static final String CHANNEL_BCH="ok_sub_spot_bch_usdt_ticker";
	public static final String CHANNEL_ETC="ok_sub_spot_etc_usdt_ticker";

	private Integer binary;
	
	private String channel;
	
	private TickterSpot data;

	public Integer getBinary() {
		return binary;
	}

	public void setBinary(Integer binary) {
		this.binary = binary;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public TickterSpot getData() {
		return data;
	}

	public void setData(TickterSpot data) {
		this.data = data;
	}
	
}
