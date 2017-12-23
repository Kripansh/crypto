package com.self.crypto.vendors.koinex;

import java.util.Map;

public class KoinexCurrencyData {

	Map<String, Double> prices;
	Map<String, KoinexCurrencyStats> stats;

	public KoinexCurrencyData() {

	}

	public Map<String, Double> getPrices() {
		return prices;
	}

	public void setPrices(Map<String, Double> prices) {
		this.prices = prices;
	}

	public Map<String, KoinexCurrencyStats> getStats() {
		return stats;
	}

	public void setStats(Map<String, KoinexCurrencyStats> stats) {
		this.stats = stats;
	}

	@Override
	public String toString() {
		return "KoinexCurrencyData [prices=" + prices + ", stats=" + stats + "]";
	}

}
