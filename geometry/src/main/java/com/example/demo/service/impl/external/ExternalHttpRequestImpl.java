package com.example.demo.service.impl.external;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.http.external.HttpClientForGetJson;
import com.example.demo.service.external.ExternalHttpRequest;

@Service
public class ExternalHttpRequestImpl implements ExternalHttpRequest {

	@Autowired
	HttpClientForGetJson httpClientForGetJson;
	
	@Override
	public String getJson(String requestUrl, Map<String, Object> requestParams) throws IOException, InterruptedException {
		// 
		String responseBody = httpClientForGetJson.getJson(requestUrl, requestParams);
		return responseBody;
	}

	@Override
	public String postJson(String requestUrl) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

}
