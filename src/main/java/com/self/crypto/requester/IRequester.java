package com.self.crypto.requester;

import com.self.crypto.exception.RequesterException;

public interface IRequester {

	public static String KOINEX = "https://koinex.in/api/ticker";

	public <T> T makeRequest(String vendor, Class<T> response) throws RequesterException;

}
