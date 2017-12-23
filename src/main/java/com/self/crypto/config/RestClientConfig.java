package com.self.crypto.config;

import java.util.concurrent.TimeUnit;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestClientConfig {

	// Determines the timeout in milliseconds until a connection is established.
	private static final int CONNECT_TIMEOUT = 30000;
	// Returns the timeout in milliseconds used when requesting a connection
	// from the connection manager.
	private static final int REQUEST_TIMEOUT = 30000;
	// Defines the socket timeout (SO_TIMEOUT) in milliseconds, which is the
	// timeout for waiting for data or,
	// put differently, a maximum period inactivity between two consecutive data
	// packets).
	private static final int SOCKET_TIMEOUT = 60000;

	private static final int MAX_TOTAL_CONNECTIONS = 100;

	private static final int IDLE_CONNECTION_WAIT_TIME = 30;

	@Bean("restTemplate")
	public RestTemplate restTemplate() {
		RestTemplate restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory(getHttpClient()));
		return restTemplate;
	}

	// Setup Httpclient
	private CloseableHttpClient getHttpClient() {
		RequestConfig requestConfig = RequestConfig.custom().setConnectionRequestTimeout(REQUEST_TIMEOUT)
				.setConnectTimeout(CONNECT_TIMEOUT).setSocketTimeout(SOCKET_TIMEOUT).build();
		// Review for https support. SocketFactory may needs to be customized
		PoolingHttpClientConnectionManager poolingConnectionManager = new PoolingHttpClientConnectionManager();
		poolingConnectionManager.setMaxTotal(MAX_TOTAL_CONNECTIONS);

		return HttpClients.custom().setDefaultRequestConfig(requestConfig)
				.setConnectionManager(poolingConnectionManager)
				.evictIdleConnections(IDLE_CONNECTION_WAIT_TIME, TimeUnit.SECONDS).build();
	}

}