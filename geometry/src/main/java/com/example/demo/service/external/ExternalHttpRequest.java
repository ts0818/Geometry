package com.example.demo.service.external;

import java.io.IOException;
import java.util.Map;

public interface ExternalHttpRequest {

	public String getJson (String requestUrl, Map<String, Object>requestParams ) throws IOException, InterruptedException;
	
	public String postJson(String requestUrl);
}
