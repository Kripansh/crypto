package com.self.crypto.vendors.koinex;

public class KoinexCurrencyStats {

	private Double last_traded_price;
	private Double lowest_ask;
	private Double highest_bid;
	private Double min_24hrs;
	private Double max_24hrs;
	private Double vol_24hrs;

	public KoinexCurrencyStats() {
	}

	public Double getLast_traded_price() {
		return last_traded_price;
	}

	public void setLast_traded_price(Double last_traded_price) {
		this.last_traded_price = last_traded_price;
	}

	public Double getLowest_ask() {
		return lowest_ask;
	}

	public void setLowest_ask(Double lowest_ask) {
		this.lowest_ask = lowest_ask;
	}

	public Double getHighest_bid() {
		return highest_bid;
	}

	public void setHighest_bid(Double highest_bid) {
		this.highest_bid = highest_bid;
	}

	public Double getMin_24hrs() {
		return min_24hrs;
	}

	public void setMin_24hrs(Double min_24hrs) {
		this.min_24hrs = min_24hrs;
	}

	public Double getMax_24hrs() {
		return max_24hrs;
	}

	public void setMax_24hrs(Double max_24hrs) {
		this.max_24hrs = max_24hrs;
	}

	public Double getVol_24hrs() {
		return vol_24hrs;
	}

	public void setVol_24hrs(Double vol_24hrs) {
		this.vol_24hrs = vol_24hrs;
	}

	@Override
	public String toString() {
		return "KoinexCurrencyStats [last_traded_price=" + last_traded_price + ", lowest_ask=" + lowest_ask
				+ ", highest_bid=" + highest_bid + ", min_24hrs=" + min_24hrs + ", max_24hrs=" + max_24hrs
				+ ", vol_24hrs=" + vol_24hrs + "]";
	}

}
