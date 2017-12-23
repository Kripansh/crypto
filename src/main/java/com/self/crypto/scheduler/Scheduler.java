package com.self.crypto.scheduler;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.self.crypto.exception.RequesterException;
import com.self.crypto.requester.IRequester;
import com.self.crypto.vendors.koinex.KoinexCurrencyData;
import com.self.mail.exceptions.MailServiceException;
import com.self.mail.service.IMailService;

@Service
public class Scheduler {

	private static final Logger LOGGER = LoggerFactory.getLogger("com.self.crypto");

	@Autowired
	IRequester requester;

	@Autowired
	IMailService mailService;

	@Value("${currency.min.value:60}")
	private Double minValue;

	@Value("${currency.max.value:75}")
	private Double maxValue;

	@Value("${currency.difference.min.value:0.5}")
	private Double fallDifferenceMin;

	@Value("${currency.difference.max.value:1}")
	private Double fallDifferenceMax;

	@Value("${currency.sender.mail}")
	private String senderMail;

	private Double currentMaxReached = 0.0;

	@Scheduled(fixedDelayString = "${scheduler.fetch.interval}")
	public void run() {
		try {
			KoinexCurrencyData currenyData = requester.makeRequest(IRequester.KOINEX, KoinexCurrencyData.class);
			LOGGER.info(currenyData.toString());
			Map<String, Double> prices = currenyData.getPrices();
			Double price = prices.get("XRP");
			if (price > currentMaxReached) {
				currentMaxReached = price;
			}
			double priceDifference = currentMaxReached - price;
			if (priceDifference > fallDifferenceMin && priceDifference < fallDifferenceMax) {
				mail("Price Fall has started: " + price);
			}
			if (price < minValue || price > maxValue) {
				mail("Price of XRP is: " + price);
			}
		} catch (RequesterException e) {
			LOGGER.error(e.getMessage());
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
	}

	private void mail(String subject) {
		try {
			mailService.sendMail(senderMail, subject, "");
		} catch (MailServiceException e) {
			LOGGER.error(e.getMessage());
		}
	}

}
