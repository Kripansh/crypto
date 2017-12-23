package com.self.crypto.requester;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.self.crypto.exception.RequesterException;

@Service
public class Requester implements IRequester {

	@Autowired
	@Qualifier("restTemplate")
	RestTemplate restTemplate;

	@Override
	public <T> T makeRequest(String vendor, Class<T> response) throws RequesterException {
		return restTemplate.getForObject(vendor, response);
	}

}
